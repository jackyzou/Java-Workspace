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
 * $Id: DelegateHttpServletRequest.java,v 1.2 1999/06/09 22:41:25 hzeller Exp $
 */
package org.apache.servlet.ssi;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Delegates all method calls to another HttpServletRequest.
 * Subclass it and override some methods.
 * @author Peter Urban
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:25 $
 */

public class DelegateHttpServletRequest
    implements HttpServletRequest {
  
    private HttpServletRequest req;
    
    /** The request all method calls are delegated to.
     */
    final protected HttpServletRequest getReq() {
	return req;
    }
  
    /** 
     * @param req The request all method calls are delegated to.
     */
    public DelegateHttpServletRequest(HttpServletRequest req) {
      this.req = req;
    }

  /*---- ServletRequest methods ----*/
  
  /**
   * Returns a buffered reader for reading text in the request body.
   * This translates character set encodings as appropriate.
   * @see getInputStream
   */
  public BufferedReader getReader()
    throws IOException {
    return req.getReader();
  }

  /**
   * Returns the size of the request entity data, or -1 if not known.
   * Same as the CGI variable CONTENT_LENGTH.
   */
  public int getContentLength() {
    return req.getContentLength();
  }

  /**
   * Returns the Internet Media Type of the request entity data, or
   * null if not known. Same as the CGI variable CONTENT_TYPE.
   */
  public String getContentType() {
    return req.getContentType();
  }

  /**
   * Returns the protocol and version of the request as a string of
   * the form <code>&lt;protocol&gt;/&lt;major version&gt;.&lt;minor
   * version&gt</code>.  Same as the CGI variable SERVER_PROTOCOL.
   */
  public String getProtocol() {
    return req.getProtocol();
  }

  /**
   * Returns the scheme of the URL used in this request, for example
   * "http", "https", or "ftp".  Different schemes have different
   * rules for constructing URLs, as noted in RFC 1738.  The URL used
   * to create a request may be reconstructed using this scheme, the
   * server name and port, and additional information such as URIs.
   */
  public String getScheme()  {
    return req.getScheme();
  }

  /**
   * Returns the host name of the server that received the request.
   * Same as the CGI variable SERVER_NAME.
   */
  public String getServerName() {
    return req.getServerName();
  }

  /**
   * Returns the port number on which this request was received.
   * Same as the CGI variable SERVER_PORT.
   */
  public int getServerPort() {
    return req.getServerPort();
  }

  /**
   * Returns the IP address of the agent that sent the request.
   * Same as the CGI variable REMOTE_ADDR.
   */
  public String getRemoteAddr() {
    return req.getRemoteAddr();
  }

  /**
   * Returns the fully qualified host name of the agent that sent the
   * request. Same as the CGI variable REMOTE_HOST.
   */
  public String getRemoteHost() {
    return req.getRemoteHost();
  }

  /**
   * Applies alias rules to the specified virtual path and returns
   * the corresponding real path, or null if the translation can not
   * be performed for any reason.  For example, an HTTP servlet would
   * resolve the path using the virtual docroot, if virtual hosting
   * is enabled, and with the default docroot otherwise.  Calling
   * this method with the string "/" as an argument returns the
   * document root.
   * @param path the virtual path to be translated to a real path
   */
  public String getRealPath(String path) {
    return req.getRealPath(path);
  }

  /**
   * Returns an input stream for reading the request body.
   */
  public ServletInputStream getInputStream()
    throws IOException {
    return req.getInputStream();
  }

  /**
   * Returns a string containing the lone value of the specified
   * parameter, or null if the parameter does not exist. For example,
   * in an HTTP servlet this method would return the value of the
   * specified query string parameter. Servlet writers should use
   * this method only when they are sure that there is only one value
   * for the parameter.  If the parameter has (or could have)
   * multiple values, servlet writers should use
   * getParameterValues. If a multiple valued parameter name is
   * passed as an argument, the return value is implementation
   * dependent: for this class, the parameter set with a
   * <tt>&lt;PARAM&gt;</tt> tag will be preferred to those posted by
   * the user.
   *
   * @param name the name of the parameter whose value is required.
   * @deprecated Please use getParameterValues
   * @see javax.servlet.ServletRequest#getParameterValues
   */
  public String getParameter(String name) {
    return req.getParameter(name);
  }

  /**
   * Returns the values of the specified parameter for the request as
   * an array of strings, or null if the named parameter does not
   * exist.  In an HTTP servlet included via the
   * <tt>&lt;SERVLET&gt;</tt> tag, these values would also include
   * any values set via a <tt>&lt;PARAM&gt;</tt> tag.
   * @param name the name of the parameter whose value is required
   * @return list of parameter values
   * @see javax.servlet.ServletRequest#getParameter
   */
  public String[] getParameterValues(String name) {
    return req.getParameterValues(name);
  }

  /**
   * Returns the parameter names for this request as an enumeration
   * of strings, or an empty enumeration if there are no parameters
   * or the input stream is empty.  The input stream would be empty
   * if all the data had been read from the stream returned by the
   * method getInputStream.
   */
  public Enumeration getParameterNames() {
    return req.getParameterNames();
  }

  /**
   * Returns the value of the named attribute of the request, or
   * null if the attribute does not exist.  This method allows
   * access to request information not already provided by the other
   * methods in this interface.  Attribute names should follow the
   * same convention as package names.  The package names java.*,
   * and javax.* are reserved for use by Javasoft, and com.sun.* is
   * reserved for use by Sun Microsystems.
   *
   * @param name the name of the attribute whose value is required
   */
  public Object getAttribute(String name) {
    return req.getAttribute(name);
  }

  /*---- HttpServletRequest ----*/

  /**
   * Returns the method with which the request was made. The returned
   * value can be "GET", "HEAD", "POST", or an extension method. Same
   * as the CGI variable REQUEST_METHOD.
   */
  public String getMethod() {
    return req.getMethod();
  }

  /**
   * Returns the request URI as a URL object.
   */
  public String getRequestURI() {
    return req.getRequestURI();
  }

  /**
   * Returns the part of the request URI that refers to the servlet
   * being invoked. Analogous to the CGI variable SCRIPT_NAME.
   */
  public String getServletPath() {
    // FIXME: giving JServSSI instead of sub-servlet!
    return req.getServletPath();
  }

  /**
   * Returns optional extra path information following the servlet
   * path, but immediately preceding the query string. Returns null if
   * not specified. Same as the CGI variable PATH_INFO.
   */
  public String getPathInfo() {
    return req.getPathInfo();
  }

  /**
   * Returns extra path information translated to a real path. Returns
   * null if no extra path information specified. Same as the CGI variable
   * PATH_TRANSLATED.
   */
  public String getPathTranslated() {
    return req.getPathTranslated();
  }

  /**
   * Returns the query string part of the servlet URI, or null if none.
   * Same as the CGI variable QUERY_STRING.
   */
  public String getQueryString() {
    return req.getQueryString();
  }

  /**
   * Returns the name of the user making this request, or null if not
   * known.  The user name is set with HTTP authentication.  Whether
   * the user name will continue to be sent with each subsequent
   * communication is browser-dependent.  Same as the CGI variable
   * REMOTE_USER.
   */
  public String getRemoteUser() {
    return req.getRemoteUser();
  }

  /**
   * Returns the authentication scheme of the request, or null if none.
   * Same as the CGI variable AUTH_TYPE.
   */
  public String getAuthType() {
    return req.getAuthType();
  }

  /**
   * Returns the value of a header field, or null if not known.
   * The case of the header field name is ignored.
   * @param name the case-insensitive header field name
   */
  public String getHeader(String name) {
    return req.getHeader(name);
  }

  /**
   * Returns the value of an integer header field, or -1 if not found.
   * The case of the header field name is ignored.
   * @param name the case-insensitive header field name
   */
  public int getIntHeader(String name) {
    return req.getIntHeader(name);
  }

  /**
   * Returns the value of a date header field, or -1 if not found.
   * The case of the header field name is ignored.
   * @param name the case-insensitive header field name
   */
  public long getDateHeader(String name) {
    return req.getDateHeader(name);
  }

  /**
   * Returns an enumeration of strings representing the header names
   * for this request. Some server implementations do not allow headers
   * to be accessed in this way, in which case this method will return null.
   */
  public Enumeration getHeaderNames() {
    return req.getHeaderNames();
  }

  /**
   * Checks whether this request is associated with a session that is
   * valid in the current session context. If it is not valid, the
   * requested session will never be returned from the getSession
   * method.
   */
  public boolean isRequestedSessionIdValid()
    {
      return req.isRequestedSessionIdValid();
    }

  /**
   * Checks whether the session id specified by this request came
   * in as part of the URL. (The requested session may not be the
   * one returned by the getSession method.)
   */
  public boolean isRequestedSessionIdFromCookie() {
    return req.isRequestedSessionIdFromCookie();
  }
  
  public HttpSession getSession(boolean value) {
    return req.getSession(value);
  }

  public String getCharacterEncoding() {
    return req.getCharacterEncoding();
  }

  public String getRequestedSessionId() {
    return req.getRequestedSessionId();
  }

  public Cookie[] getCookies() {
    return req.getCookies();
  }

  public boolean isRequestedSessionIdFromUrl() {
    return req.isRequestedSessionIdFromUrl();
  }

}



