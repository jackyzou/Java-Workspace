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

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.util.Vector;

/**
 * The <CODE>SSI</CODE> servlet provides support for including dynamic servlet
 * output from within HTML documents via the <CODE>&lt;SERVLET&gt;</CODE> tag.
 * It also supports some of the SSI directives (tags like
 * <CODE>&lt;!--#include file="header.html" --&gt;</CODE>);
 * see the docs for the Apache module <CODE>mod_include</CODE>.
 *
 * <h3>Configuring the Apache Server</h3>
 * <blockquote>
 *
 * <p>In order to take advantage of the capabilities provided by this
 * class, you must first configure your Apache web server so that it
 * knows how to pass documents which will contain
 * <CODE>&lt;SERVLET&gt;</CODE> tags to this class.
 *
 * <p>Typically, this is done by naming files with <CODE>SERVLET</CODE>
 * tags with a ".jhtml" extension, and adding the following lines to
 * your Apache server configuration file:
 *
 *   <code><pre>
 *   # enable &lt;servlet&gt; tag in .jhtml files
 *   ApJServAction .jhtml /<i>servletZone</i>/org.apache.servlet.ssi.SSI
 *   </pre></code>
 *
 * where <i>servletZone</i> is the URI from which your servlets
 * are accessed. (This is often "<code>/servlets</code>".)
 *
 * <p>
 * (<i>optional</i>) In order to use SSI directives,
 * you've to insert a line in your <i>zone</i>.properties
 * file to provide an init argument to the SSI servlet:
 *   <code><pre>
 *   servlet.org.apache.servlet.ssi.SSI.initArgs=SSISiteRoot=/site/root
 *   </pre></code>
 * Replace <code>/site/root</code> by the top level directory of your site.
 * This is the <code>DocumentRoot</code> in your Apache configuration file.
 *
 * <p>
 * Beware, the SSI directives are not (yet) fully implemented. 
 * You only have part of the functionality of 
 * <CODE>#config</CODE>,
 * <CODE>#echo</CODE>, <CODE>#include</CODE>,
 * <CODE>#flastmod</CODE> and <CODE>#fsize</CODE>. 
 * 
 * </blockquote>
 * <h3>Including Servlets in HTML Pages</h3>
 * <blockquote>
 *
 * <h4>The <CODE>&lt;SERVLET&gt;</CODE>
 *  and <CODE>&lt;/SERVLET&gt;</CODE> tags</h4>
 *
 * <p>Servlet output may be included in an HTML document by use of
 * the <CODE>&lt;SERVLET&gt;</CODE> tag.  For example, to embed the
 * output of the demo "HelloWorldServlet" servlet in an HTML page, you
 * might write the following:
 *
 *   <code><pre>
 *   <i>... (some HTML code) ...</i>
 *   &lt;SERVLET CODE="HelloWorldServlet.class"&gt;
 *   Your web server has not been configured to support servlet tags.
 *   &lt;/SERVLET&gt;
 *   <i>... (more HTML code) ...</i>
 *   </pre></code>
 *
 * <p>When this page is served from the web server, the code above
 * will be replaced with the output of HelloWorldServlet.
 * If you see the message between the tags instead, there is a problem
 * with your server configuration.  If this happens, check to make sure
 * your file has a ".jhtml" extension and that the Apache server is
 * configured as described above.
 *
 * <p>Two attributes are used by the <CODE>SERVLET</CODE> tag,
 * and they are roughly equivalent:
 * <ol>
 * <p><li>The <CODE>CODE</CODE> attribute may be set to the name of a class file
 *     (the ".class" extension is optional) containing the servlet
 *     to be run.  Currently, this servlet must be installed in the
 *     same directory as the other servlets, not in the directory
 *     where your HTML resides.
 * <p><li>The <CODE>NAME</CODE> attribute may also be set to the name of the
 *     servlet to be run (with no class extension).
 * </ol>
 * <p>In some implementations of <CODE>SERVLET</CODE> tags, if
 * both <CODE>NAME</CODE> and <CODE>CODE</CODE> attributes are set, the
 * servlet designated by <CODE>CODE</CODE> will then become available for
 * future use under the symbolic named designated by the <CODE>NAME</CODE>
 * attribute.  This is not currently supported.
 *
 * <p>Note that both the <CODE>&lt;SERVLET&gt;</CODE> and
 * <CODE>&lt;/SERVLET&gt;</CODE> tags must be present.
 * <h4>Initialization parameters</h4>
 *
 * <p>With this newer version of SSI, it is now possible to
 * to specify initialization parameters correctly -- in the
 * <CODE>&lt;SERVLET&gt;</CODE> tag, that is.
 *
 * <p>If no extra parameters beyond <CODE>NAME</CODE> and
 * <CODE>CODE</CODE> are supplied, initialization does not happen
 * when the servlet is invoked.  If a set of parameters is supplied to the
 * servlet the <CODE>SERVLET</CODE> tag, like so:
 *
 * <PRE>
 * &lt;SERVLET code="SnoopServlet" abc="One Two Three" Xyz=456&gt;
 * </PRE>
 *
 * <p>Then SnoopServlet will be initialized with these parameters
 * when this servlet is invoked this way.  If two <CODE>SERVLET</CODE>
 * tags supply two different set of parameters, then each one is
 * supplied before the <code>service</code> method is invoked.
 * This is hardly optimal, but is dictated by the architecture.
 *
 * <h4>The <CODE>&lt;PARAM&gt;</CODE> tag</h4>
 *
 * <p>You may send parameters to a servlet via the <CODE>PARAM</CODE> tag, which
 * should be placed between the <CODE>&lt;SERVLET ... &gt;</CODE> and
 * <CODE>&lt;/SERVLET&gt;</CODE> tags, like so:
 *
 *   <code><pre>
 *   &lt;SERVLET CODE="MyServlet.class"&gt;
 *   &lt;PARAM NAME="param1" VALUE="valueOfParam1"&gt;
 *   &lt;PARAM NAME="anotherParam" VALUE="valueOfAnotherParam"&gt;
 *   &lt;/SERVLET&gt;
 *   </pre></code>
 *
 * <p>You could then access these parameters from your
 * servlet as follows:
 *
 *   <code><pre>
 *   public void doGet(HttpServletRequest req, HttpServletResponse res)
 *       throws ServletException, IOException
 *   {
 *       String param1 = req.getParameter("param1");
 *       String anotherParam = req.getParameter("anotherParam");
 *   }
 *   </pre></code>
 *
 * </blockquote>
 * <h3>Notes</h3>
 * <blockquote>
 *
 * <dl>
 * <p><dt><b>Attribute values</b>
 * <dd>Attribute values, <CODE>NAME</CODE> and <CODE>VALUE</CODE>
 * in the <CODE>PARAM</CODE> tag may be a single word
 * (<CODE>NAME=xyz value=1</CODE>) or must be enclosed in quotes
 * if they contain whitespace
 * (<CODE>NAME=xyz VALUE="This is a test"</CODE>).
 *
 * <p><dt><b>Case sensitivity and SGML</b>
 * <dd>This class does not care about case when reading
 * SGML tags or their attributes, so uppercase, or lowercase, or any
 * combination thereof may be used.  The text in attribute values
 * is not translated to upper- or lowercase but is passed on intact.
 *
 * <p><dt><b>Error handling</b>
 * <dd>To simplify error detection and correction,
 * exceptions thrown by JServSSI or called servlets are printed,
 * enclosed in comments ("&lt;!-- ... --&gt;"), in the HTML output.
 *
 * </blockquote>
 *
 * @author Roger Zeng
 * @author Tim Williams
 * @author <A href="mailto:zeller@think.de">Henner Zeller</A>
 * @author Matthias Wiesmann
 * @author Peter Urban
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:28 $
 * @see javax.servlet.http.HttpServlet
 * @see org.apache.servlet.ssi.PageParser
 * @see org.apache.servlet.ssi.ServletTagHandler
 */

public class SSI 
    extends PageParserServlet {
    
  private final static String SSIROOT = "SSISiteRoot";

  /**
   * Initialize SSI
   * @param config servlet configuration, stored by superclass
   * @exception ServletException passed on from superclass
   */
  public void init(ServletConfig config)
    throws ServletException
    {
      super.init(config);
      try {
	  getParser().addTagHandler("SERVLET",
				    "org.apache.servlet.ssi.ServletTagHandler");
	if (config.getInitParameter(SSIROOT) != null) {
	    try {
		SSITagHandler.setSiteRoot (config.getInitParameter (SSIROOT));
		getParser().addTagHandler("!--#ECHO", 
					  "org.apache.servlet.ssi.EchoTagHandler");
		getParser().addTagHandler("!--#FLASTMOD",
					  "org.apache.servlet.ssi.FLastModTagHandler");
		getParser().addTagHandler("!--#FSIZE",
					  "org.apache.servlet.ssi.FSizeTagHandler");
		getParser().addTagHandler("!--#CONFIG",
					  "org.apache.servlet.ssi.ConfigTagHandler");
		getParser().addTagHandler("!--#INCLUDE",
					  "org.apache.servlet.ssi.IncludeTagHandler");
	    }
	    catch (java.io.IOException ioe) {
		log ("SSI-Servlet " + ioe.getMessage() +
		     "; disabling '<!--#...' - SSI features");
	    }
	}
      }
      catch (ClassNotFoundException e) {
	throw new ServletException ("Unable to load ServletTagHandler: "+
				    e.getMessage());
      }
    }

    /**
     * Creation of an interpretation context.
     * @see SSIContext
     */
    protected ParseContext createInterpretationContext(File file, 
						       HttpServletRequest req,
						       HttpServletResponse res)
    {
	return new SSIContext(file, req, res, getParser());
    }

  /**
   * Return information about SSI to caller.
   * @return string explaining this what this servlet does
   * and referring the user to the javadocs.
   */
    public String getServletInfo()
    {
    return "SSI is a servlet which processes <SERVLET> tags "
        + "in .jhtml files and replaces such tags with the "
        + "output of the servlets to which they refer. "
        + "See the documentation on org.apache.servlet.ssi.SSI "
        + "for more information.";
    }

}
