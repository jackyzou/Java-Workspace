/*
 * Copyright (c) 1997-1999 The Java Apache Project.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. All advertising materials mentioning features or use of this
 *    software must display the following acknowledgment:
 *    "This product includes software developed by the Java Apache 
 *    Project for use in the Apache JServ servlet engine project
 *    (http://java.apache.org/)."
 *
 * 4. The names "Apache JServ", "Apache JServ Servlet Engine" and 
 *    "Java Apache Project" must not be used to endorse or promote products 
 *    derived from this software without prior written permission.
 *
 * 5. Products derived from this software may not be called "Apache JServ"
 *    nor may "Apache" nor "Apache JServ" appear in their names without 
 *    prior written permission of the Java Apache Project.
 *
 * 6. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the Java Apache 
 *    Project for use in the Apache JServ servlet engine project
 *    (http://java.apache.org/)."
 *    
 * THIS SOFTWARE IS PROVIDED BY THE JAVA APACHE PROJECT "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JAVA APACHE PROJECT OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Java Apache Group. For more information
 * on the Java Apache Project and the Apache JServ Servlet Engine project,
 * please see <http://java.apache.org/>.
 *
 */

/*
 * $Id: SSITagHandler.java,v 1.2 1999/06/09 22:41:29 hzeller Exp $
 */
package org.apache.servlet.ssi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;
import java.io.*;

/**
 * A TagHandler implementing common functionality and utilities
 * for traditional SSI tags: &lt;!--# ...&gt;
 * @see org.apache.servlet.ssi.SSI
 * @see org.apache.servlet.ssi.EchoTagHandler
 * @author Matthias Wiesmann, Peter Urban
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:29 $
 */

public abstract class SSITagHandler 
  implements SpecialTagHandler, 
	     FilenameFilter
{
  long startPos;
  long endPos;
  ServletConfig servletConfig;

  protected SGMLTag parameters;  

  /**
   * Parse special tag.
   * This method is invoked if a tag with a name
   * this class is registered for is found.
   * It gets the ServletConfiguration of the PageParser
   * servet, the whole file content in a string and the
   * tag found tag.<p>
   * The <CODE>readTag()</CODE> method is called <em>before</em>
   * any processing is done. Its purpose is to parse the area
   * this tag spans and probably read in parameters used at
   * execution time.<p>
   * This method returns the last tag belonging to the
   * area handled by this Handler (for server side included
   * servlets, this would be <CODE>&lt;/SERVLET&gt;</CODE>).
   * For simple one-tag Handlers this is simply the tag passed
   * to this method. If the Handler decides not to handle this tag, this 
   * method should return <CODE>null</CODE>.
   * @param config Servlet configuration
   * @param text   file content
   * @param myTag  the SGMLTag found in the file.
   * @see   org.apache.java.util.SGMLTag
   */
  public SGMLTag readTag (ServletConfig config, 
			  PositionReader input, 
			  long startPosition,
			  SGMLTag tag) 
    throws IOException {
     this.servletConfig = config;
    /*
     * parse the full tag to get all parameters
     * (i.e. an optional 'format'-parameter)
     * and to place the Reader at the position
     * after the closing '>'
     */
    tag.parse (input);
    if (!tag.isWellFormed()) {
	return null;
    }
    
    /*
     * The Offset is the space the reader skipped
     * before it reached the opening '<'
     *   <!-- a comment --> some garbage <DATE>
     * ^----- offset --------------------^
     */
    startPos = startPosition + tag.getOffset();
    
    /*
     * The current Position is after the closing
     * '>'
     */
    endPos = input.getPosition();
    
    parameters = tag;

    return tag;
  }

  /**
   * Get start position of the area in the sourcefile this
   * handler processes.
   */
  public long getTagStart () { return startPos; }

  /**
   * Get the length of the area in the sourcefile.
   * The area this handler processes is skipped in the inputfile.
   *
   * Since we just have a single tag, this is just the area
   * this tag spans:
   */
  public long getTagLength () { return endPos - startPos; }

    // Stuff from SSICommand. To be replaced in future.

    /** The root directory of the web server.
     *  This value is initialised from the init parameter
     * <code>SSISiteRoot</code>.
     */ 
    protected static File site_root  ;

    static void setSiteRoot (String rootPath) 
	throws IOException, NullPointerException
    {
	// Preparing the site_root 
	site_root = new File(rootPath);
	if (!site_root.isDirectory())
	    throw new IOException ("SSISiteRoot: Directory expected");
    }

    /** Checks if a file exists, if not prints an error message.
     *  @param file the file to check
     *  @param out the output stream for the error message
     *  @return <code>true</code> if the file exists 
     *  @see java.io.File#exists
     */ 

    protected boolean checkFile(File file, ServletOutputStream out)
	throws IOException
    {
	/*
	 * FIXME:Security : shouldn't we make sure that
	 * files beyond site_root are not readable,
	 * i.e. canonicalPath(file).startsWith(canonicalPath(siteRoot)) 
	 * ? (hen)
	 */
	if (file == null) {
	    out.print("<!-- Probably bad syntax -->");
	    return false;
	} else if (!file.exists()) {
	    out.print("<!-- File "+file+" does not exist -->");
	    return false; 
	} else {
	    return true;
	}
    } // checkFile

    /** Filters for index files.<br> 
     *  This method decides which files are accepted to
     *  be used for directory place holder. 
     *  @param dir the directory of the file
     *  @param name the name of the file 
     */ 

    public boolean accept(File dir, String name)
	{
	    return name.startsWith("index");
	} // accept 

    /** Checks if a file is a directory, 
     *  if this is the case, it returns the 
     *  <code>index</code> file of the directory.
     *  if not it returns the file itself.
     *  @param file the file to check
     *  @return either the file itself, or the index file
     *  @exception IOException file is not valid.
     *  @see NoIndexException
     */ 

    protected File checkIndex(File file) throws IOException
	{
	    if (! file.isDirectory()) return file ;
	    String[] subfiles = file.list(this); 
	    if (subfiles.length==0) throw new NoIndexException(file);
	    return new File(file,subfiles[0]);
	} // checkIndex

    /** Checks if a filename is absolute 
     * @param name the name of the file
     * @return <code>true</code> if the file name is absolute
     */

    protected boolean isAbsolute(String name)
	{
	    if (name.startsWith("/")) return  true ;
	    return  false; 
	} // isAbsolute

    final public static String VIRTUAL_PARAM = "VIRTUAL" ;
    final public static String FILE_PARAM = "FILE" ;

    /** Finds a virtual or file parameter.<br>
     * <strong>Note:</strong> should be made more compliant. 
     * The file is found using te <code>VIRTUAL</code> parameter.
     * <ul>
     * <li> If the path is relative, 
     *      it is resolved relatively to the parsed document. 
     * <li> If the path is absolute, 
     *      it is resolved relatively to the directory specified 
     *      in the <code>user.home</code> System property. 
     * </ul>
     * The file is found using the <code>FILE</code> parameter.
     * <ul>
     * <li> If the path is relative, 
     *      it is resolved relatively to the parsed document. 
     * <li> If the path is absolute, 
     *      it is resolved relatively to the site root. 
     *      This directory is specified in the <code>SITE_ROOT</code>
     *      system property. 
     * </ul>
     * @see #site_root
     * @return the file associated with the parameter. 
     */

    protected File getFileParameter(SSIContext context)
	throws IOException
    {
	String filename;
	filename = parameters.value(VIRTUAL_PARAM, null);
	if (filename != null) {
	    if (isAbsolute(filename)) {
		return (site_root == null) ? null : new File(site_root,filename);
	    } // if 
	    final String path = context.file.getParent();
	    final File file = new  File(path,filename);
	    return checkIndex(file); 
	} // getVirtual
	
	filename = parameters.value(FILE_PARAM, null);
	if (filename != null) {
	    if (isAbsolute(filename)) 
		return  (site_root == null) ? null : new File(site_root,filename);
	    final String path = context.file.getParent();
	    final File file = new File(path,filename);
	    return checkIndex(file);       
	}

	return null;
    }

}

/** This exception is thrown when no index file was found
 *  for a directory.
 * @see SSICommand#checkIndex
 * @author Matthias Wiesmann
 * @version 1.0
 */ 

class NoIndexException extends IOException
{
    /** The error message */ 
    protected final static String NO_INDEX = "No index for " ;
    protected NoIndexException(File file) 
	{
	    super(NO_INDEX+file.toString());
	} // NoIndexException
} // NoIndexException

