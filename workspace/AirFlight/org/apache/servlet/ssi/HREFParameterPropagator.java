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

import java.io.IOException;
import java.net.URLEncoder;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;

/**
 * a TagHandler which inserts GET parameters
 * to any &lt;A HREF=...&gt; link in a page.
 *
 * <p><em><b>This is currently experimental</b></em><p>
 *
 * Just add this handler to a PageParser servlet in the init()
 * method as handler for the tag having the interesting <CODE>HREF</CODE>'s<p>.
 * If the tagname is <CODE>FRAME</CODE>, URLs in the SRC argument is
 * rewritten (see <a href="#getParameterPlace">getParameterPlace()</A>).
 * <CODE><PRE>
 *  addTagHandler ("A", "org.apache.servlet.ssi.HREFParameterPropagator");
 *  addTagHandler ("FRAME", "org.apache.servlet.ssi.HREFParameterPropagator");
 *  // rewrite AREA tags within image MAPs
 *  addTagHandler ("AREA", "org.apache.servlet.ssi.HREFParameterPropagator");
 * </PRE></CODE>
 * <p>see the ParameterPropagatingSSI for a code example. 
 * <p>
 * The HREFParameterPropagator expects a semicolon ( ; ) seperated
 * list of parameters to propagate in the initParameter 
 * <CODE>PropagateParameters</CODE> of the PageParser servlet using
 * this handler.
 * @see org.apache.servlet.ssi.PageParser
 * @see org.apache.servlet.ssi.ParameterPropagatingSSI
 * @author <A href="mailto:zeller@think.de">Henner Zeller</A>
 * @version $Revision: 1.3 $ $Date: 1999/06/22 22:50:18 $
 */
public class HREFParameterPropagator 
    implements SpecialTagHandler {

  private ServletConfig config;
  private boolean addonParameter = false;
  private long insertPos;
  private String propagateParameterList = null;
  
  /**
   * a String with the 
   * name of the initParameter (<CODE>PropagateParameters</CODE>)
   * containing the semicolon seperated list of Parameters to propagate.
   * (e.g. <CODE>servlet.SSI.initArgs=PropagateParameters=JServSession;Language;userid</CODE>)
   */
  public final static String INIT_PROPPARAM_LIST = "PropagateParameters";

  /**
   * initialize HREFParameterPropagator.
   */
  public HREFParameterPropagator() { 
    // nope
  }

  /**
   * Parse the <CODE>&lt;A HREF=...&gt;</CODE> tag.
   * This method is invoked if a &lt;A&gt;-tag is
   * found.
   * It gets the ServletConfiguration of the PageParser
   * servet, the whole file content in a string and the
   * SGMLTag.<p>
   * The <CODE>readTag()</CODE> method is called <em>before</em>
   * any processing is done. Its purpose is to parse the area
   * this tag spans and probably read in parameters used at
   * execution time.<p>
   * This very method reads the tag and figures out the
   * position where GET-paramters at the end of the
   * URL could be inserted. If this &lt;A&gt;-tag doesn't contain
   * a <CODE>HREF=</CODE> part, a valid URL or should
   * not be rewritten 
   * (see <A HREF="#rewriteThisURL"><CODE>rewriteThisURL()</CODE></a>),
   * it just returns <CODE>null</CODE>,
   * signaling the PageParser to forget about this tag.<p>
   * Since this <CODE>HREFParameterPropagator</CODE> just <em>inserts</em>
   * stuff in the code and <em>doesn't replace</em> tags with its
   * output, the length of the area spanned by this TagHandler is zero.
   * This method returns the last tag belonging to the
   * area handled by this Handler, so in this case its the same tag
   * we got as parameter.
   *
   * @param config Servlet configuration
   * @param text   file content
   * @param myTag  the SGMLTag found in the file.
   * @see   #getTagLength
   * @see   #executeTag
   * @see   #rewriteThisURL
   * @see   org.apache.java.util.SGMLTag
   */
  /*
   * find the end of the HREF="...." - Parameter
   */
  public SGMLTag readTag (ServletConfig config, 
			  PositionReader input, 
			  long startPosition,
			  SGMLTag tag) 
    throws IOException
    {
    this.config = config;
    propagateParameterList = config.getInitParameter (INIT_PROPPARAM_LIST);

    // if there are no Parameters, propagating is
    // pointless:
    if (propagateParameterList == null)
      return null;

    // handle tags where the URL is stored in this Attribute
    String URLparameter = getParameterPlace(tag);
    
    /*
     * we do not call parse() of the SGMLTag
     * since we're just interested in the exact
     * position of the end of the URL
     */
    boolean foundHREF=false;
    String token = "";
    while (true) {
      token = tag.nextToken(input);
      if (token == null || token.equals (">"))
	break;
      
      foundHREF= URLparameter.equals(token.toUpperCase());
      
      // skip equals sign
      token = tag.nextToken(input);
      if (!"=".equals (token))
	continue;

      // this is the value
      token = tag.nextToken(input);
      if (foundHREF) {
	insertPos = input.getPosition();
	if (token.charAt(0) == '"' || token.charAt(0) == '\'') {
	  // store bare URL in token
	  token = token.substring(1, token.length() - 1);
	  insertPos--;
	}
	break; // found it
      }
    }
    // this should never happen at this stage:
    if (!foundHREF)
      return null;

    // allow the HREFParameterPropagator user to
    // decide which URLs should be rewritten.
    if (!rewriteThisURL (config, token))
      return null;

    // if we have a ? in the URL, there are already
    // GET parameters attached to the URL, so we've
    // to append our parameters with '&'
    int questPos = token.indexOf('?');
    addonParameter = (questPos >= 0);

    int hashPos = token.indexOf('#');
    // do not rewrite URL's referring to the current document
    // (they start with the '#')
    if (hashPos == 0)
      return null;

    /*
     * GET Parameters should be placed _before_ the #subsection part of
     * the URL, so correct the position we found (end of URL) here.
     *
     * If there are already  GET parameters attached (see '?' test before)
     * to the URL _after_ the #-part, 
     * ( HREF="foobar.html#subsect?bar=baz" 
     *                 instead of
     *   HREF="foobar.html?bar=baz#subsect")
     * do _not_ correct position in this case.
     * (note that, if there is no GET parameter in the first place, questPos=-1)
     */
    if (hashPos > 0 && questPos < hashPos) {
      // move backwards the length of the subsection part
      insertPos -= (token.length() - hashPos);
    }

    return tag;
  }

  /**
   * Get start position of the area in the sourcefile this
   * handler processes.
   * The start position of the HREFParameterPropagater is the
   * end of the URL.
   */
  public long getTagStart () { return insertPos; }

  /**
   * Get the length of the area in the sourcefile.
   * The area this handler processes is skipped in the inputfile.
   * The HREFSessionPropagator <em>inserts</em> some text to the
   * output, but lets the rest of the tag untouched, so this
   * function returns 0.
   */
  public long getTagLength () { return 0; }

  /**
   * This function gives you the power to decide, which URL's
   * are to be rewritten if you overwrite it.
   * It is called in the parsing process with the
   * URL found and, by default, returns always true.
   * With this function you can implement not to rewrite
   * URLs which point to places not inside your domain or whatever.
   * @param config The servlet configuration of the PageParser servlet
   *               using this handler, so you can read the initParameters
   * @param url    A string containing the URL found.
   * @return true/false (boolean)
   */
  public boolean rewriteThisURL (ServletConfig config, String url) { 
    return true;
  }

  /**
   * returns where to look for the URL to be rewritten.
   * @param inTag The current tag to be considered
   * @return an uppercased String containing the parametername
   *         of the URL. This default implementation returns
   *         <CODE>SRC</CODE> for a tag named <CODE>FRAME</CODE>
   *         (so a &lt;FRAME SRC=&quot;foobar.jhtml&quot;> gets
   *         rewritten) and <CODE>HREF</CODE> otherwise.
   *         overwrite this function if you want to use the
   *         ParameterPropagator for other tags
   */
  public String getParameterPlace (SGMLTag inTag) {
    return (inTag.isNamed("FRAME") ? "SRC" : "HREF");
  }

  /**
   * insert the parameters at the computed position.
   * Just goes through the list of parameters and constructs
   * a list of GET parameters if they're non-null.
   */
  public void executeTag (ParseContext context)
    throws IOException {
      ParamPropContext pcontext = (ParamPropContext) context;

      /*
       * first invocation: build parameter string
       */
      if (pcontext.hrefParameterAppend == null) {
	  StringTokenizer params = new StringTokenizer (propagateParameterList, ";");
	  String parameterName, parameterValue;
	  StringBuffer outBuffer = new StringBuffer();
	  boolean first = true;
	  while (params.hasMoreTokens()) {
	      parameterName = params.nextToken();
	      if (parameterName == null)
		  continue;
	      parameterValue = context.getServletRequest().getParameter (parameterName);
	      if (parameterValue == null)
		  continue;
	      if (!first) outBuffer.append ("&");
	      outBuffer.append (URLEncoder.encode(parameterName));
	      outBuffer.append ("=");
	      outBuffer.append (URLEncoder.encode(parameterValue));
	      first = false;
	  }
	  // if we're in the first position, no variables
	  // have been rewritenn
	  pcontext.hrefRewriteNecessary = !first;
	  pcontext.hrefParameterAppend = outBuffer.toString().getBytes();
      }

      /*
       * do the actual rewrite: insert parameter string at
       * the current position of the stream which is
       * the precalculated position.
       */
      if (pcontext.hrefRewriteNecessary) {
	  ServletOutputStream out = context
	      .getServletResponse()
	      .getOutputStream();
	  /*
	   * write() calls are much faster than out.print() calls
	   */
	  out.write (addonParameter ? '&' : '?');
	  out.write (pcontext.hrefParameterAppend);
      }
  }
}
