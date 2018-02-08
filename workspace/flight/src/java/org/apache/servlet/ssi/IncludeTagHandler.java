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
 * $Id: IncludeTagHandler.java,v 1.2 1999/06/09 22:41:26 hzeller Exp $
 */
package org.apache.servlet.ssi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;

import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;

/**
 * This class implements the SSI include command.
 *  Both <code>FILE</code> and <code>VIRTUAL</code>
 *  parameters are supported. 
 *  Refer to the <code>SSITagHandler</code> class to see 
 *  how those parameters are handled. 
 *  @see SSITagHandler#getFileParameter 
 *  @author Matthias Wiesmann, Peter Urban
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:26 $
 */

public class IncludeTagHandler 
    extends SSITagHandler {

    /**
     * actually perform the action associated with this tag.
     *  The file included files is <strong>always</strong>
     *  parsed for SSI commands
     *  @see SSI
     *  @exception java.io.IOException file problem
     *  @exception javax.servlet.ServletException exception from
     * the SSI servlet
     * processing the include file 
     */
    public void executeTag (ParseContext context) 
	throws IOException, ServletException
    {
	if (!isParameterOK()) return;
	SSIContext ssiContext = (SSIContext) context;
	final File file = getFileParameter(ssiContext);
	if (!checkFile(file, context.getServletResponse().getOutputStream())) return; 
	// FIXME: check for recursivly included files here ..
	HttpServletRequest origRequest = context.getServletRequest();
	context.setServletRequest (new IncludeRequest(file.getCanonicalPath(),
						      origRequest));
	ssiContext.parser.process (file, servletConfig, context);
	context.setServletRequest (origRequest);
    }

    /** Parameter check.
     * File parameters shouldn't be absolute nor contain "..".
     */
    private boolean isParameterOK()
	throws IOException
    {
	String filename = parameters.value(FILE_PARAM, null);
	return ( filename == null ||
		 ( filename.indexOf(".." + File.separator) == -1 &&
		   !(new File(filename).isAbsolute()) ) );
    }

}

/** The original request, but getPathTranslated is modified 
 * to hold the name of the include file.
 * The SSI servlet will be invoked with this request
 * to process the include file.
 */

class IncludeRequest
    extends DelegateHttpServletRequest 
{

    private String filename;

    /** @param filename name of the include file
     * @param req the original request
     */
    public IncludeRequest(String filename, HttpServletRequest req)
    {
	super(req);
	this.filename = filename;
    }

    /** Returns the name of the include file.
     */
    public String getPathTranslated() {
	return filename;
    }
}


