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
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * ToDo for JSDK 2.1 compliance:
 * delegate
 * encodeRedirectURL()
 */

/**
 * This class just delegates methods to the supplied HttpServletResponse
 * -- with one exception.  It won't delegate the getOutputStream or
 * getWriter methods -- those it'll handle itself.
 *
 * All of this is to compensate for stupid examples in the JSDK which
 * suggest closing the ServletOutputStream in a servlet which is used
 * w/ in an SSI page.  This terminates the display of the page at that
 * point, which is generally not the intention.
 *
 * @author Ed Korthof
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:28 $
 **/
public class SSIHttpServletResponse implements HttpServletResponse {

    private HttpServletResponse res     = null;
    private ServletOutputStream out_raw = null;
    private ServletOutputStream out     = null;
    private PrintWriter servlet_writer  = null;
    private boolean called_getOutputS   = false;

    public SSIHttpServletResponse (HttpServletResponse res,
				   ServletOutputStream out_raw) {
        this.res = res;
        out = new org.apache.servlet.ssi.SSIOutputStream(out_raw);
    }

    public SSIHttpServletResponse (HttpServletResponse res)
            throws IOException {
	this (res, res.getOutputStream());
    }

    /**
     * Returns an output stream for writing binary response data.
     * @exception IllegalStateException if getWriter has been
     *      called on this same request.
     * @exception IOException if an I/O exception has occurred.
     * @see #getWriter
     */
    public ServletOutputStream getOutputStream() throws IOException {
        if ( servlet_writer != null ) {
            throw new IllegalStateException( "Already called getWriter" );
        } else {
            called_getOutputS = true;
            return out;
        }
    }

    /**
     * Returns a print writer for writing formatted text responses.  The
     * MIME type of the response will be modified, if necessary, to reflect
     * the character encoding used, through the <em>charset=...</em>
     * property.  This means that the content type must be set before
     * calling this method.
     * @exception IllegalStateException if getOutputStream has been
     *        called on this same request.
     * @exception IOException on other errors.
     * @exception UnsupportedEncodingException if the character set encoding
     * @see #getOutputStream
     * @see #setContentType
     */
    public PrintWriter getWriter() throws IOException {
        if (called_getOutputS) {
            throw new IllegalStateException("Already called getOutputStream.");
        } else if (servlet_writer == null) {
            // UnsupportedEncodingException is thrown not by
            // getCharacterEncoding, which only parses the content-type header
            // which specifies the encoding, but by the Writer constructor,
            // which possibly cannot support the encoding specified.
            OutputStreamWriter osw_out =
                new OutputStreamWriter(out, getCharacterEncoding());
            servlet_writer = new PrintWriter(osw_out);
        }
        return servlet_writer;
    }

// All of these get delegated, w/o any thought.  These are from
// ServletResponse
    public void setContentLength(int l)       { res.setContentLength(l);      }
    public void setContentType(String t) { 
	/**
	 * Do not allow embedded Taglets to set the
	 * ContentType.
	 *
	 * This works for jserv since it doesn't set
	 * any headers once the OutputStream is active
	 * but e.g. JavaWebServer may set it afterwards.
	 * The ss_include_example.shtml from JWS distribution
	 * shows up as text/plain, then, because
	 * the embedded DateServlet sets its
	 * ContentType to text/plain (testet on JWS 1.1.3)
	 *
	 * FIXME: This _may_ make problems with getWriter() which
	 * calls getCharacterEncoding() which relies on
	 * the content type ..
	 */
	 
	// res.setContentType(t);       Do nothing
    }
    public String getCharacterEncoding() {
        return res.getCharacterEncoding();
    }

// All of these get delegated, w/o any thought.  These are from
// HttpServletResponse
    public void addCookie (Cookie c)          { res.addCookie(c);             }
    public boolean containsHeader (String n)  { return res.containsHeader(n); }
    public void setStatus(int sc, String sm)  { res.setStatus(sc, sm);        }
    public void setStatus(int sc)             { res.setStatus(sc);            }
    public void setHeader(String n, String v) { res.setHeader(n, v);          }
    public void setIntHeader(String n, int v) { res.setIntHeader(n, v);       }
    public String encodeUrl(String url)       { return res.encodeUrl(url);    }
    public void sendError(int sc, String msg) throws IOException {
        res.sendError(sc, msg);
    }
    public void sendError(int sc) throws IOException {
        res.sendError(sc);
    }
    public void sendRedirect(String location) throws IOException {
        res.sendRedirect(location);
    }
    public void setDateHeader(String n, long d) {
        res.setDateHeader(n, d);
    }
    public String encodeRedirectUrl(String url) {
        return res.encodeRedirectUrl(url);
    }

    /* --- default access --- */
    final void flush_out () throws IOException {
      if (servlet_writer != null)
	servlet_writer.flush();
      if (called_getOutputS || servlet_writer != null)
	  out.flush();
    }

    final void reInit() {
	servlet_writer = null;
	called_getOutputS = false;
    }
}

