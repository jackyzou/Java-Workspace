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
 * $Id: ExampleTagHandler.java,v 1.2 1999/06/09 22:41:26 hzeller Exp $
 */
package org.apache.servlet.ssi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;
/**
 * Simple TagHandler which can be added to the PageParser Servlet.
 * Just add this handler to a PageParser servlet in the init()
 * method:<br>
 * <CODE>
 * addTagHandler ("DATE", "org.apache.servlet.ssi.ExampleTagHandler");
 * </CODE>
 * see the SSI for a code example.
 * <p>
 * A PageParser prepared with this handler will replace any
 * tag <CODE>&lt;DATE&gt;</CODE> with the current date in the
 * format <b>HH:mm:ss dd MMMMM yyyy</b> or in any format you can
 * pass as <em>format</em> attribute; e.g. <br>
 * <code>&lt;DATE format=&quot;HH:mm&quot;&gt;</code><br>
 * just prints the current time.
 *
 * @see org.apache.servlet.ssi.PageParser
 * @see org.apache.servlet.SSI
 * @author <A href="mailto:zeller@think.de">Henner Zeller</A>
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:26 $
 */
public class ExampleTagHandler 
  implements SpecialTagHandler {
  long startPos;
  long endPos;

  SimpleDateFormat formatter = null;

  /**
   * initialize ExampleTagHandler.
   */
  public ExampleTagHandler() { }

  /**
   * Parse special tag.
   * This method is invoked if a tag with a name
   * this class is registered for is found.
   * It gets the ServletConfiguration of the PageParser
   * servet and a PositionReader, placed after name of
   * the current tag.<p>
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
   * @see   org.apache.java.io.PositionReader
   */
  public SGMLTag readTag (ServletConfig config, 
			  PositionReader input, 
			  long startPosition,
			  SGMLTag tag) 
    throws IOException {
    /*
     * parse the full tag to get all parameters
     * (i.e. an optional 'format'-parameter)
     * and to place the Reader at the position
     * after the closing '>'
     */
    tag.parse (input);
    
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
    
    /*
     * initialize a DateFormatter with the 'format'-attribute
     * given
     */
    formatter  = new SimpleDateFormat (tag.value ("format", "HH:mm:ss dd MMMMM yyyy"));
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
   */
  /*
   * Since we just have a single tag, this is just the area
   * this tag spans:
   */
  public long getTagLength () { return endPos - startPos; }

  /**
   * actually perform the action associated with this tag.
   * Print current date/time.
   */
  public void executeTag (ParseContext context) 
    throws IOException {
    ServletOutputStream out = context.getServletResponse().getOutputStream();
    out.print (formatter.format(new Date()));
  }
}

