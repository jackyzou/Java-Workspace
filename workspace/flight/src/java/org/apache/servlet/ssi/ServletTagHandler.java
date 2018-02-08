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

/* TODO:
 * (from Tim Williams, williams@ugsolutions.com:)
 * - Support "CODEBASE" servlet tag, allowing remote loading of servlets
 * - Make "NAME" parameter work for symbolic names, not just "CODE"
 * - Integrate functionality with James' modifications (reddirt@texas.edu)
 */

/*
 * This is the part of the former JServSSI which
 * handles servlet invocation of the <SERVLET> .. </SERVLET>
 * tag
 */
package org.apache.servlet.ssi;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;

public class ServletTagHandler
  implements ServletConfig, SpecialTagHandler
{
  private SGMLTag tag;
  private ServletConfig config = null;
  private Hashtable params = null;
  private boolean requiresInit = false;
  private long length = 0;
  private long startPos = 0;

  /*---- Class instantiation and maintenance ----*/
  
  ServletTagHandler() { }
  
  SGMLTag getSGMLTag() {
    return tag;
  }
  
  boolean requiresInit() {
    return requiresInit;
  }
  
  /*
   * Implementation of SpecialTagHandler
   */
  
  /**
   * Get start position of the area in the sourcefile this
   * handler processes.
   */
  public long getTagStart() {
    return startPos;
  }

  /**
   * Get the length of the <CODE>&lt;SERVLET&gt; - &lt;/SERVLET&gt;</CODE> area
   * in the source file.
   * This is skipped on output of the inputfile
   */
  public long getTagLength() {
    return length;
  }
  
  /**
   * Parse <CODE>&lt;SERVLET&gt;</CODE> tag and 
   * area until <CODE>&lt;/SERVLET&gt;</CODE>.
   * This method returns the last SGMLTag for <CODE>&lt;/SERVLET&gt;</CODE>
   * @param config Servlet configuration
   * @param text   file content
   * @param startTag  the SGMLTag found in the file.
   * @see   org.apache.servlet.ssi.SpecialTagHandler
   */
  public SGMLTag readTag (ServletConfig config, 
			  PositionReader input,
			  long startPosition,
			  SGMLTag startTag)
    throws IOException
    {
      this.config = config;
      this.tag = startTag;

      this.params = new Hashtable();

      startTag.parse (input);
      if (!startTag.isWellFormed())
	return null;
      startPos = startPosition + startTag.getOffset();

      SGMLTag currentTag = startTag;

      while (!currentTag.finished()) {
	currentTag = new SGMLTag(input);

	// get parameters from <PARAM ..> tags within <SERVLET>..
	if (currentTag.isNamed("PARAM") && 
	    currentTag.isWellFormed()) {
	  String name = currentTag.value("NAME", null);
	  String value = currentTag.value("VALUE", null);
	  if (name != null && value != null) {
	      // A servlet can have several parameters of the same
	      // name, therefore the values of param will be String arrays.
	      String[] array;
	      String[] oldArray = (String[])params.get(name);
	      if (oldArray == null) {
		  array = new String[1];
		  array[0] = value;
	      } else {
		  array = new String[oldArray.length+1];
		  System.arraycopy(oldArray, 0, array, 0, oldArray.length);
		  array[oldArray.length] = value;
	      }
	      params.put(name, array);
          }
	}
	
	// servlet invocation is closed with </SERVLET>
	else if (currentTag.isNamed("/SERVLET") && 
		 currentTag.isWellFormed()) {
	  length = input.getPosition() - startPos;
	  // determine if this has any initialization parameters of its own
	  // do _not_ mangle config parameters passed to SSI-Servlet
	  Enumeration names = startTag.attributes(true); // true -> UppperCase
	  while (names.hasMoreElements() && !requiresInit) {
	    String name = (String) names.nextElement();
	    if (!name.equals("NAME") && !name.equals("CODE"))
	      requiresInit = true;
	  }
	  break; // read </SERVLET>: we're done
	}
      }
      return currentTag;
    }

  /**
   * Do it - execute the servlet in question
   * @exception Exception that comes from executing the servlet
   */
  public void executeTag (ParseContext context)
    throws Exception {
    ServletInfoRequest ireq = new ServletInfoRequest(params, 
						     context.getServletRequest());
    ireq.runServlet(this, getServletContext(), context.getServletResponse());
  }

  /*---- ServletConfig methods ----*/

  /**
   * Returns the context for the servlet.
   */
  public ServletContext getServletContext() {
    return config.getServletContext();
  }

  /**
   * Returns a string containing the value of the named
   * initialization parameter of the servlet, or null if the
   * parameter does not exist.  Init parameters have a single string
   * value; it is the responsibility of the servlet writer to
   * interpret the string.
   * @param name the name of the parameter whose value is requested
   * @return value of name, or null if unset
   */
  public String getInitParameter(String name)
    {
      /* FIXME: see below */
      //      return tag.value(name, config.getInitParameter(name));
      return tag.value(name, null);
    }

  /**
   * Returns the names of the servlet's initialization parameters
   * as an enumeration of strings, or an empty enumeration if there
   * are no initialization parameters.
   * @return enumeration of key values as strings
   */
  public Enumeration getInitParameterNames() {
    return tag.attributes(false);
    /**** FIXME: (hen)
     * This looks considerably broken to me:
     * we're mangeling the config of the _SSI_-Servlet (passed to readTag)
     * with the config of the servlet to be included instead of just
     * getting the init parameters from the attributes.
     *
     * Applying parameters to a Servlet which is actually
     * an alias with already defined initParameters should
     * add/override _them_ .. not the ones from SSI, passed
     * as union to the included servlet.
     *
     * I've to look into this a bit deeper but the
     * best way probably would be to get the default initparams of the
     * servlet in question (in runServlet()), replace the init here
     * (with something like ServletTagHandler.setConfigInit()) ...
     * ... then the following code makes sense again:
     return union(
     tag.attributes(false),
     config.getInitParameterNames());
    **/
  }

  /*---- Internal utilities ----*/

  /**
   * Given two enumerations, create an enumeration containing
   * elements in both of them, with redundant elements only occuring
   * once.  Elements are returned in no particular order.
   * @param a first enumeration
   * @param b second enumeration
   * @return union of elements found in sets
   */
  static Enumeration union(Enumeration a, Enumeration b) {
    Hashtable seen = new Hashtable();
    while (a.hasMoreElements())
      seen.put(a.nextElement(), new Boolean(true));
    while (b.hasMoreElements())
      seen.put(b.nextElement(), new Boolean(true));
    return seen.keys();
  }
}

class ServletInfoRequest
    extends DelegateHttpServletRequest {

  private Hashtable params;
  private static Hashtable lastInfo = new Hashtable();
  
  ServletInfoRequest(Hashtable params, HttpServletRequest req) {
      super(req);
      this.params = params;
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
    String[] value = (String[]) params.get(name);
    String rvalues[] = getReq().getParameterValues(name);
    return value != null ? value[0] :
      (rvalues != null && rvalues.length > 0 ? rvalues[0] : null);
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
    String[] values = getReq().getParameterValues(name);
    String[] paramStrings = (String[]) params.get(name);
    String[] these;
    if (paramStrings != null) {
      if (values != null) {
	these = new String[values.length+paramStrings.length];
	System.arraycopy(values, 0, these, paramStrings.length, values.length);
	System.arraycopy(paramStrings, 0, these, 0, paramStrings.length);
      } else {
	these = paramStrings;
      }
    } else {
      these = values;
    }
    return these;
  }

  /**
   * Returns the parameter names for this request as an enumeration
   * of strings, or an empty enumeration if there are no parameters
   * or the input stream is empty.  The input stream would be empty
   * if all the data had been read from the stream returned by the
   * method getInputStream.
   */
  public Enumeration getParameterNames() {
    return ServletTagHandler.union(params.keys(), getReq().getParameterNames());
  }

  /**
   * Returns the part of the request URI that refers to the servlet
   * being invoked. Analogous to the CGI variable SCRIPT_NAME.
   */
  public String getServletPath() {
    // FIXME: giving JServSSI instead of sub-servlet!
    return getReq().getServletPath();
  }

  /*---- Local Stuff ----*/

  /**
   * Invoke servlet for this page section.
   */
  void runServlet(ServletTagHandler info,
		  ServletContext context, HttpServletResponse res)
    throws Exception
    {
      // figure which servlet we want
      SGMLTag tag = info.getSGMLTag();
      String className = tag.value("CODE", null);
      if (className != null) {
        if (className.endsWith(".class"))
	  className = className.substring(0,
		  className.length() - new String(".class").length());
      }
      else {
        className = tag.value("NAME", null);
        if (className == null)
	  throw new ServletException("no class named in servlet tag");
      }
      
      // load servlet
      Servlet servlet = context.getServlet(className);
      if (servlet == null)
        throw new ClassNotFoundException(
		 "can't find servlet named \"" + className + "\"");

      // determine if initialization is required
      if (info.requiresInit() && lastInfo.get(servlet) != info) {
        servlet.init(info);
        lastInfo.put(servlet, info);
      }

      // there is no defined way to get a STM-servlet to execute
      // it. The behaviour is undefined
      if (servlet instanceof SingleThreadModel &&
	  servlet instanceof GenericServlet) {
	  ((GenericServlet) servlet).log ("WARNING: its not save to execute " +
					  "SingleThreadModel-servlets with Apache JSSI; see docs");
      }

      // execute servlet
      servlet.service((ServletRequest) this, (ServletResponse) res);
    }
}

