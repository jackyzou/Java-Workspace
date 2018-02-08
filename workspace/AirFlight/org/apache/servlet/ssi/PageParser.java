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

package org.apache.servlet.ssi;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;

/**
 * <CODE>PageParser</CODE> 
 * parses SGML markup'd pages and executes
 * <em>active</em> Tag. Returns its output
 * through a HttpServletResponse (given in a ParseContext).
 * Active Tags are handled with SpecialTagHandlers which
 * can be registered for a specific Tag.
 *
 * <p><h4>Error handling:</h4>
 * To simplify error detection and correction,
 * exceptions thrown by the <CODE>executeTag()</CODE>-methods of the
 * pluggable handlers (e.g. called servlets) are printed,
 * enclosed in comments ("&lt;!-- ... --&gt;"), in the HTML output.
 *
 * @author Roger Zeng
 * @author Tim Williams
 * @author current maintainer <A href="mailto:zeller@think.de">Henner Zeller</A>
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:27 $
 * @see javax.servlet.http.HttpServlet
 * @see org.apache.servlet.ssi.ExampleTagHandler
 * @see org.apache.servlet.ssi.ParseContext
 * @see org.apache.servlet.ssi.SpecialTagHandler
 */

public class PageParser
{
  /**
   * File info holds the parse information for
   * a file .. and some statistical stuff which 
   * may be interesting for administrative
   * frontends
   */
  private final class FileInfo {
    Vector parts;
    long   lastModified;
    long   parseTime;
    public FileInfo () {};
  }

  /**
   * This hashtable contains the cached parsed
   * pages, saved in FileInfo-Objects.
   * This may be considered to be replaced by 
   * a WeakHashMap when JDK1.2 is available on 
   * all Platforms
   */
  private Hashtable pages = null;

  /**
   * a Hashtable with key/value=tagname/handlerClass
   * (e.g. 'SERVLET'/org.apache.servlet.ssi.ServletTagHandler)
   */
  private Hashtable handlerClasses = null;

  public PageParser () {
      pages = new Hashtable();
      handlerClasses = new Hashtable();
  }

  /**
   * Process the file in question.
   * @param file          The file containing SGML markup
   * @param ServletConfig Servlet configuration of the calling
   *                      servlet. This is to pass parameters
   *                      to the tag handlers.
   * @param ParseContext  The context used while parsing; contains
   *                      at least the HttpServletRequest and
   *                      HttpServletResponse.
   * @see ParseContext
   */
  public void process (File file,  
		       ServletConfig config,  // this should be a general
		                              // nv-pair class; e.g. a Dictionary
		       ParseContext context) 
      throws IOException {
      interpretPage(file, 
		    getPageParts(file, config), context);
  }

  /**
   * register a handler for a specific tag (Class name).
   * @param tagname the name of the tag like 'MYSPECIALTAG' or 'SERVLET'
   * @param handlerClassName the <em>name of class</em> implementing the
   *                         action for this tag. This class must
   *                         implement the PageParser.SpecialTagHandler
   *                         interface.
   * @exception ClassNotFoundException if the class with the specified
   *                                   name is not found.
   */
  public void addTagHandler (String tagname, String handlerClassName) 
    throws ClassNotFoundException {
    handlerClasses.put (tagname.toUpperCase(),
			Class.forName (handlerClassName));
  }

  /**
   * register a handler for a specific tag (Class).
   * @param tagname the name of the tag like 'MYSPECIALTAG' or 'SERVLET'
   * @param handlerClass the <em>class</em> implementing the
   *                     action for this tag. This class must
   *                     implement the PageParser.SpecialTagHandler
   *                     interface.
   */
  public void addTagHandler (String tagname, Class handlerClass) {
    handlerClasses.put (tagname.toUpperCase(), handlerClass);
  }

  public Enumeration getRegisteredTags () {
    return handlerClasses.keys();
  }

  /**
   * If HTML file has changed or has not yet been loaded, load
   * file and chop into sections, storing result for future use.
   * Otherwise, return stored preprocessed page.
   * @param file file for which we want page section list
   * @return list of page sections, as described in parsePage().
   * @see #parsePage
   */
  private Vector getPageParts(File file, 
			      ServletConfig config)
    throws IOException
    {
      // first, check to see if we have cached version
      FileInfo fileInfo = (FileInfo) pages.get(file);
      if (fileInfo == null   ||
	  fileInfo.lastModified != file.lastModified()) {
	// if no cached version, or modified, load
	fileInfo = parsePage (file, config);
	pages.put(file, fileInfo);
      }
      return fileInfo.parts;
    }

  /**
   * Scan through vector of page sections and build
   * output. 
   * Read the static areas of the file and copy them to the 
   * output until the beginning of the next special tag. Invokes
   * the <CODE>executeTag()</CODE> Method for the tag
   * and goes on with copying.
   * or invoking the servlets to which they refer.
   * @param parts page sections, as provide by parsePage()
   * @see #parsePage
   */
  private void interpretPage(File file, Vector parts, ParseContext context)
      throws IOException
    {
      HttpServletResponse res_raw = context.getServletResponse();
      // output
      ServletOutputStream out = res_raw.getOutputStream();

      FileInputStream fileInStream = null;
      byte buf[] = null;

      try {
	  // input
	  fileInStream = new FileInputStream(file);
	  long inPos = 0;
	  
	  /*
	   * create ServletResponse once and reuse it
	   */
	  SSIHttpServletResponse res = new SSIHttpServletResponse(res_raw);
	  context.setServletResponse (res);

	  /*
	   * Get Copy Buffer.
	   * REVISE: this should use a buffer Manager:
	   * a org.apache.java.util.SimpleQueue which stores buffers. This way
	   * the JVM doesn't have to garbage collect the buffers
	   * created here, and we are allowed to use larger Buffers
	   * here.
	   */
	  buf = new byte[4096]; // Get buffer from Buffer Manager
	  
	  for (int i = 0; i < parts.size(); i++) {
	      SpecialTagHandler part = (SpecialTagHandler) parts.elementAt(i);
	      // copy file content till the beginning of the Tag:
	      copy (fileInStream, out, part.getTagStart()-inPos, buf);
	      try{
		  part.executeTag (context);
		  res.flush_out();
	      }
	      /*
	       * Display any Exceptions as
	       * comment in the page
	       */
	      catch (Exception e) { 
		  PrintWriter pout = new PrintWriter(out);
		  out.println("<!-- ERROR: ------------");
		  e.printStackTrace(pout);
		  pout.flush();
		  out.println("-->");
	      }
	      /*
	       * init reuseable ServletResponse
	       */
	      res.reInit();
	      // put it back to the context if someone changed it
	      // somewhere .. (e.g. recursivly called PageParser ..)
	      context.setServletResponse (res);
	      
	      // skip the <SPECIAL_TAG> ... </SPECIAL_TAG> area:
	      fileInStream.skip(part.getTagLength());
	      inPos = part.getTagStart()+part.getTagLength();
	  }
	  // copy rest until end of file
	  copy (fileInStream, out, -1, buf);
      }
      finally {
	  // clean up resouce: opened input file
	  if (fileInStream != null)
	      fileInStream.close();
	  buf = null; // return buffer to Buffer Manager
      }
      out.flush();
    }


  /**
   * copies an InputStream to an OutputStream. copies max. length
   * bytes
   */
  private static void copy(InputStream in, OutputStream out, long length,
			   byte buf[]) 
    throws IOException 
    {
	int len;
	boolean limited = (length >= 0);
	int rest = limited ? (int) length : buf.length;
	while( rest > 0 &&
	       (len = in.read(buf, 0, 
			      (rest > buf.length) ? buf.length : rest)) > 0) {
	    out.write(buf, 0, len);
	    if (limited) rest -= len;
	}
    }
    
  /**
   * Open and read file, returning list of contents.
   * The returned vector will contain a list of
   * <CODE>SpecialTagHandler</CODE>s, containing the
   * position/length within the input file they are
   * responsible for.
   * This Vector is used within <CODE>interpretPage()</CODE>
   * to create the output.
   *
   * @param file file to open and process
   * @return FileInfo containing page elements.
   * <!-- see private <a href="#interpretPage">interpretPage()</a> -->
   */
  private FileInfo parsePage(File file, ServletConfig config)
    throws IOException
    {
      /*
       * read file contents. The SGMLTag requires
       * to read from a Reader which supports the
       * mark() operation so we need a BufferedReader
       * here
       */
      PositionReader fin = null;
      fin = new PositionReader (new BufferedReader (new FileReader(file)));
      FileInfo fileInfo = new FileInfo();

      try {
	// scan through page parsing SpecialTag statements
	fileInfo.lastModified = file.lastModified();
	fileInfo.parts = new Vector();
	long startPos;
	SGMLTag tag, endTag;
	long StartTime = System.currentTimeMillis();
	do {
	  endTag = null;
	  startPos = fin.getPosition();
	  tag = new SGMLTag(fin, false);
	  if (tag.getName() != null) {
	    String upName = tag.getName().toUpperCase();
	    if (handlerClasses.containsKey(upName)) {
	      SpecialTagHandler handler = null;
	      try {
		Class handlerClass = (Class) handlerClasses.get(upName);
		handler =  (SpecialTagHandler) handlerClass.newInstance();
		endTag = handler.readTag (config, fin, startPos, tag);
	      }
	      catch (Exception e) {
		System.err.println (e.getMessage());
	      }
	      if (endTag != null) {
		fileInfo.parts.addElement (handler);
	      }
	    }
	  }
	} 
	while (!tag.finished());
	fileInfo.parseTime = System.currentTimeMillis() - StartTime;
	/***
	    System.err.println ("PageParser: parsing '" + file + "' took " + 
	    fileInfo.parseTime + "ms for " +
	    fileInfo.parts.size() + " handlers");
	***/
      }
      finally {
	if (fin != null) fin.close();
      }
      return fileInfo;
    }
}
