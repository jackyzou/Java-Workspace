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
import org.apache.java.util.*;

/**
 * <CODE>ParameterPropagatingSSI</CODE> 
 * provides support for including dynamic servlet
 * output from within HTML documents via the <CODE>&lt;SERVLET&gt;</CODE> tag,
 * and additionally adds GET parameters to any URL found in the page with
 * parameters given to the page.
 *
 * <p>This is especially useful if you want to hold the state of your
 * session but don't want rewrite each URL within your page 'by hand' and
 * do <em>not</em> use cookies which may annoy the user of
 * your webpage.<p>
 * With the technique offered here you're able to hold your state without
 * much efford accross your website.
 *
 * <p>For the SSI servlet, see documentation there.
 * 
 * <h3>Configuring the Apache Server</h3>
 * <blockquote>
 * <p>Like the SSI servlet, this servlet must be registered for
 * a specific extension. Use whatever extension you want; often it's useful
 * to replace the SSI servlet completely with this ParameterPropagatingSSI
 * servlet since it implements a superset. 
 * <p>
 * But first you've to insert a servlet alias in your <i>zone</i>.properties
 * file in order to provide an init argument containing a semicolon ( ; )
 * seperated list of all parameters which should be propagated (here:
 * <em>JServSession</em> and <em>userid</em>)
 *   <code><pre>
 *   servlet.JServSSI.code=org.apache.servlet.ssi.ParameterPropagatingSSI
 *   servlet.JServSSI.initArgs=PropagateParameters=JServSession;userid
 *   </pre></code>
 *
 * now, you can add this <em>alias</em> as handler for .jhtml files in your
 * jserv.conf:
 *   <code><pre>
 *   # enable &lt;servlet&gt; tag and parameter propagating in in .jhtml files
 *   ApJServAction .jhtml /<i>servletZone</i>/JServSSI
 *   </pre></code>
 *
 * where <i>servletZone</i> is the URI from which your servlets
 * are accessed. (This is often "<code>/servlets</code>".)
 *
 * </blockquote>
 *
 * @author Roger Zeng
 * @author Tim Williams
 * @author <A href="mailto:zeller@think.de">Henner Zeller</A>
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:27 $
 * @see org.apache.servlet.ssi.SSI
 * @see org.apache.servlet.ssi.PageParser
 * @see org.apache.servlet.ssi.ServletTagHandler
 */

public class ParameterPropagatingSSI 
  extends SSI {
  private String parameterList;
  /**
   * Initialize SSI
   * @param config servlet configuration, stored by superclass
   * @exception ServletException passed on from superclass
   */
  public void init(ServletConfig config)
    throws ServletException
    {
      super.init(config);
      parameterList = config.getInitParameter(HREFParameterPropagator.INIT_PROPPARAM_LIST);
      try {	
	/*
	 * only use the URL-rewriting extension, if the user
	 * requests it by setting the 'PropagateParameters'
	 * initParam to SSI to avoid parsing overhead.
	 */
	if (parameterList != null) {
	  getParser().addTagHandler("A", 
				    "org.apache.servlet.ssi.HREFParameterPropagator");
	  getParser().addTagHandler("FRAME", 
				    "org.apache.servlet.ssi.HREFParameterPropagator");
	  // AREA tags within image MAP's:
	  getParser().addTagHandler("AREA", 
				    "org.apache.servlet.ssi.HREFParameterPropagator");
	}
      }
      catch (ClassNotFoundException e) {
	throw new ServletException ("Unable to load parameter propagating handler: "+
				    e.getMessage());
      }
    }

   /**
    * Creation of an interpretation context.
    * @see SSIContext
    */
    protected ParseContext createInterpretationContext(File file, 
						       HttpServletRequest req,
						       HttpServletResponse res) {
	return new ParamPropContext(file, req, res, getParser());
    }

  /**
   * Return information about SSI to caller.
   * @return string explaining this what this servlet does
   * and referring the user to the javadocs.
   */
    public String getServletInfo()
    {
      StringBuffer desc = new StringBuffer();
      desc.append(super.getServletInfo() + " "
		  + "Additionally, this ParameterPropagatingSSI "
		  + "servlet rewrites URLs in several "
		  + "tags to propagate parameters passed to the page "
		  + "as GET parameter");
      if (parameterList == null) {
	desc.append (", but there are no parameters configured to propagate; you can provide them");
      }
      else {
	desc.append (". This is done with the following parameters to pages: '" +
		     parameterList +"'. These are configured");
      }
      
      desc.append (" with the initArgument '" 
		   + HREFParameterPropagator.INIT_PROPPARAM_LIST 
		   + "' which takes a semicolon separated list of "
		   + "parameters. The following tags are configured to "
		   + "be handled in a special way with this servlet: ");
      
      for (Enumeration e = getParser().getRegisteredTags() ; e.hasMoreElements() ;) {
	desc.append ("<" + e.nextElement() + "> ");
      }
      
      desc.append (". See the documentation on " +
		   "org.apache.servlet.ssi.ParameterPropagatingSSI " +
		   "for more information");
      
      return desc.toString(); 
    }
}
