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
import java.util.zip.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;

/**
 * <CODE>PageParserServlet</CODE> provides support for including dynamic servlet
 * output from within HTML documents via a special tag.
 * 
 * This is an abstract class which is used by the SSI Servlet handling
 * the special <CODE>&lt;SERVLET&gt; .. &lt;/SERVLET&gt;</CODE>-Tag.
 * This can be easily extended with pluggable tag handlers
 * implementing the SpecialTagHandler interface.
 *
 * <p><em>further documentation required ... See ExampleTagHandler
 * for an easy implementation of a TagHandler and SSI or
 * ParameterPropagatingSSI for inclusion of Handlers</em><p>
 *
 * <p><h4>Error handling:</h4>
 * To simplify error detection and correction,
 * exceptions thrown by the <CODE>executeTag()</CODE>-methods of the
 * pluggable handlers (e.g. called servlets) are printed,
 * enclosed in comments ("&lt;!-- ... --&gt;"), in the HTML output.
 *
 * <p><h3>History:</h3>
 * The PageParserServlet used to be the JServSSI servlet which has
 * been generalized to handle any special tag. The SSI servlet is just
 * an application of the PageParserServlet.
 *
 * @author Roger Zeng
 * @author Tim Williams
 * @author current maintainer <A href="mailto:zeller@think.de">Henner Zeller</A>
 * @version $Revision: 1.4 $ $Date: 1999/06/19 09:35:17 $
 * @see javax.servlet.http.HttpServlet
 * @see org.apache.servlet.ssi.ExampleTagHandler
 */


abstract public class PageParserServlet
  extends HttpServlet
{
  /**
   * used to parse the tagged files
   */
  private PageParser parser;

  /**
   * a long specifying the seconds the generated
   * document expires
   */
  private Long expiresIn = null;

  /**
   * a long specifying the size, an output should
   * be compressed
   */
  private Long compressLargerThan = null;
  private Hashtable heuristicSize;

  /**
   * Buffer the output. 
   *  Pro's
   *    - allows the embedded TagHandlers to set headers
   *    - is a bit faster
   *  Con's
   *    - The user has to wait until the _whole_ page is 
   *      generated
   *    - may use a bit more memory
   */
   private boolean bufferedOutput = false;

  /**
   * a string specifying the charset
   * document charset
   */
   private String charset = null;
    
  /**
   * Make debug output. If true, the time the servlet takes
   * to process the page is log()-ed
   */
   private boolean logProcessTime = false;

  /**
   * Initialize PageParser.
   * @param config servlet configuration, stored by superclass
   * @exception ServletException passed on from superclass
   */
  public void init(ServletConfig config)
    throws ServletException
    {
      super.init(config);
      parser = createParser();

      /*
       * SSI documents contain dynamic content which usually
       * expires at the time it is served; if we don't set the
       * Expires-header, clients may choose to cache the page ..
       * The expires init argument allows to set a relative expire
       * date (to generation time).
       */
      try {
	  if (config.getInitParameter ("expires") != null) {
	      expiresIn = Long.valueOf (config.getInitParameter ("expires"));
	  }
      }
      catch (NumberFormatException e) {
	  log ("Invalid format for expires initParam; expected integer (seconds)");
      }

      /*
       * compress files it the output becomes larger than compresslarge
       */
      try {
	  if (config.getInitParameter ("compresslarge") != null) {
	      compressLargerThan = 
		  Long.valueOf (config.getInitParameter ("compresslarge"));
	      if (compressLargerThan.longValue() < 0)
		  throw new NumberFormatException ();
	      heuristicSize = new Hashtable();
	  }
      }
      catch (NumberFormatException e) {
	  log ("Invalid format for compresslarge initParam; expected positve integer (Bytes))");
	  compressLargerThan = null;
      }
      
      // get buffered-flag
      if (config.getInitParameter ("buffered") != null) {
	  String b = config.getInitParameter ("buffered");
	  bufferedOutput=b.toUpperCase().startsWith("Y")
	      || b.equals("1");
      }

      // get debug-flag
      if (config.getInitParameter ("debug") != null) {
	  String b = config.getInitParameter ("debug");
	  logProcessTime=b.toUpperCase().startsWith("Y")
	      || b.equals("1");
      }
      
      // get Charset
      if (config.getInitParameter ("charset") != null)
	  charset=config.getInitParameter ("charset");
    }

  /**
   * Handle POST the same as GET.
   * This method is simply a call to doGet().
   * @param req encapsulates the request to the servlet
   * @param resp encapsulates the response from the servlet
   * @see javax.servlet.http.HttpServletRequest#getPathTranslated
   * @exception ServletException will be passed on from included servlets
   * @see #doGet
   */
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    doGet(req, res);
  }

  /**
   * Process named page HTML passed found via getPathTranslated().
   * @param req encapsulates the request to the servlet
   * @param resp encapsulates the response from the servlet
   * @see javax.servlet.http.HttpServletRequest#getPathTranslated
   * @exception ServletException will be passed on from included servlets
   */
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

      // Set content type and - if given as init argument - the charset
      if (charset != null)
	  res.setContentType("text/html; charset="+charset);
      else
	  res.setContentType("text/html");    

    // parse file contents
    String path = req.getPathTranslated();

    if (path == null) {
      error( HttpServletResponse.SC_INTERNAL_SERVER_ERROR,     // 500
	     "Could not resolve the given URI <B>" + req.getRequestURI()
	     + "<P><B>NOTE</B>: SSI/PageParser cannot work if the "
	     + "requested file is not accessible by the servlet engine. "
	     + "Please, make sure the requested file is readable by "
	     + "this servlet and located on the same machine.", res);
    } else {
      File file = new File(path);
      if (!file.isFile()) {
	error(HttpServletResponse.SC_NOT_FOUND,              // 404
	      "Requested URI <B>" + req.getRequestURI()
	      + "</B> is not a file. "
	      + "Please, make sure you request a "
	      + "java server side include file.", res);
      } else if (!file.exists()) {
	error(HttpServletResponse.SC_NOT_FOUND,              // 404
	      "Requested URI <B>" + req.getRequestURI()
	      + "</B> was not found. "
	      + "Please, make sure this file exists."
	      + "<P><B>NOTE</B>: JServSSI cannot work if the requested "
	      + "file is not accessible by the servlet engine. "
	      + "Please, make sure the requested file is located on the"
	      + "same machine.", res);
      } else if (!file.canRead()) {
	error(HttpServletResponse.SC_FORBIDDEN,              // 403
	      "Requested URI <B>" + req.getRequestURI()
	      + "</B> could not be accessed. "
	      + "Please, make sure the servlet engine (and thus: "
	      + "this SSI/PageParser servlet) has rights "
	      + "to read the requested file.", res);
      } else {
	  /*
	   * set "Expired:" header if relative expire time
	   *  supplied. see comment in init() method as well.
	   */
	  if (expiresIn != null) {
	      res.setDateHeader ("Expires", 
				 (new java.util.Date()).getTime() + 
				 expiresIn.longValue() * 1000);
	  }

	  long StartTime = 0;
	  if (logProcessTime) StartTime = System.currentTimeMillis();
	  HttpServletResponse processResponse = res;
	  OutputStream raw_out = null;
	  
	  /*
	   * buffering
	   */
	  if (bufferedOutput) 
	      raw_out = new ByteArrayOutputStream(4096);
	  else 
	      raw_out = res.getOutputStream();

	  OutputStream pipedStream = raw_out;
	  /*
	   * negotiate compression ..
	   */
	  if (compressLargerThan != null) {
	      // retrieve and interpret page
	      String encodings = req.getHeader ("Accept-Encoding");
	      String userAgent = req.getHeader ("User-Agent");
	      Long size = (Long) heuristicSize.get (file);
	      boolean mayCompress = 
		  (encodings != null) &&
		  /*
		   * Workaround of BUG in M$-IE
		   * MicroSoft Internet Explorer claims to understand
		   * compression .. but in fact doesn't.
		   */
		  ((userAgent == null) || (userAgent.indexOf ("MSIE") < 0)) &&
		  (size != null)      &&
		  (size.longValue() > compressLargerThan.longValue());
		  
	      if (mayCompress && encodings.indexOf("gzip") >= 0) {
		  res.setHeader ("Content-Encoding", "gzip");
		  res.setHeader ("Vary", "Accept-Encoding");
		  pipedStream = new GZIPOutputStream (pipedStream);
	      }
	      else if (mayCompress && encodings.indexOf("compress") >= 0) {
		  res.setHeader ("Content-Encoding", "compress");
		  res.setHeader ("Vary", "Accept-Encoding");
		  pipedStream = new ZipOutputStream (pipedStream);
	      }
	  }
	  //
	  // add additional filters to pipedStream here
	  // ...
	  
	  OSServletOutputStream  servletStream = 
	      new OSServletOutputStream (pipedStream);
	  processResponse = new SSIHttpServletResponse (res, servletStream);

	  /*
	   * do the processing of the page ..
	   * FIXME: create a delegating HttpServletRequest
	   *   which doesn't return an Accept-Encoding Header since
	   *   sub-Servlets may not decide to compress their output ..
	   *   that would give a mess.
	   */
	  getParser().process (file, getServletConfig(),
			       createInterpretationContext(file,req,processResponse));
	  servletStream.close();

	  /*
	   * compression related cleanup: save statistics
	   */
	  if (compressLargerThan != null) {
	      /*
	       * The size of generated pages is dynamic and thus, subject of
	       * change. So calculate the heuristic size as a weighted
	       * mean value. Weights are 1/2 + 1/4 + 1/8 + ...
	       */
	      Long oldSize = (Long) heuristicSize.get(file);
	      if (oldSize != null) {
		  heuristicSize.put (file, 
				     new Long ((servletStream.size() + 
						oldSize.longValue()) / 2));
	      }
	      else
		  heuristicSize.put (file, new Long (servletStream.size()));
	  }
	  
	  /*
	   * flush buffered Output
	   */
	  if (bufferedOutput) {
	      ByteArrayOutputStream o = (ByteArrayOutputStream) raw_out;
	      res.setContentLength (o.size());
	      o.writeTo(res.getOutputStream());
	  }
	  
	  if (logProcessTime) {
	      long duration = System.currentTimeMillis() - StartTime;
	      log ("processing '" + file + "' took " + duration + "ms");
	  }
	  raw_out = null;  // be nice to the gc
      }
    }
  }

  /**
   * Sends error as servlet output
   */
  private void error(int error, String message, HttpServletResponse res)
    throws IOException {
    res.setStatus (error);
    res.getOutputStream().println("<HTML>"
	  + "<HEAD><TITLE>" + error + " SSI Error</TITLE></HEAD>"
	  + "<BODY><H2>" + error + " Java Server Side Include Error</H2><p>"
	  + message + "<HR></BODY></HTML>");
  }
    
  /**
   * @return the PageParser used.
   */
  public PageParser getParser() { return parser; }

  /* --- Factory Methods  --- */
  /**
   * Factory method to create a Parser. Returns
   * a default PageParser.
   * @return a new PageParser
   * @see PageParser
   */
  public PageParser createParser() {
      return new PageParser();
  }

  /**
   * Factory method; creates a context for the interpretation of one page.
   * This context can be used to hold page specific configuration 
   * info for SSI tags, or to pass information between SSI tags.
   * <br>
   * E.g., <code>#config</code> modifies the date format, 
   * and a subsequent <code>#flastmod</code> uses this new format
   * for displaying the modification time.
   * <br>
   * The default implementation does nothing.
   * <!-- see private <a href="#interpretPage">interpretPage()</a> -->
   */
   abstract protected ParseContext createInterpretationContext(File file,
						HttpServletRequest req,
						HttpServletResponse res);

  /**
   * Clean up servlet when finished.
   */
  public void destroy() {
      super.destroy();
      parser = null;
  }

  /**
   * Return information about PageParser to caller. This
   * should be implemented by the servlet extending this PageParser.
   * If not, this default implementation gives a list of
   * all tag names for registered handlers.
   *
   * @return string explaining this what this servlet does
   * and referring the user to the javadocs.
   */
  public String getServletInfo()
    {
      StringBuffer outText = new StringBuffer();
      outText.append ("PageParserServlet is a general servlet which");
      outText.append ("processes special SGML-tags. ");
      outText.append ("See the documentation of the servlet extending ");
      outText.append ("this PageParser (which should have overwritten ");
      outText.append ("this info) for more information; ");
      outText.append ("This processes the following tags: ");
      for (Enumeration e = parser.getRegisteredTags(); 
	   e.hasMoreElements();
	   /* nope */) {
	  outText.append ("<" + e.nextElement() + "> ");
      }
      return outText.toString();
    }
}
