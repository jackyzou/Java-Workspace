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
 * $Id: EchoTagHandler.java,v 1.2 1999/06/09 22:41:25 hzeller Exp $
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
 * A minimalist implementation of the SSI 
 * <code>echo</code> command.
 * It supports the following variables:<ul>
 * <li><code>DOCUMENT_NAME</code>
 * <li><code>LAST_MODIFIED</code>
 * <li><code>DATE_GMT</code>
 * </ul>
 * @author Matthias Wiesmann
 * @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:25 $
 */

public class EchoTagHandler 
    extends SSITagHandler {

    protected final static String VAR_PARAM = "VAR" ;
    protected final static String ABOUT_MSG = "Java SSI Implementation by Matthias Wiesmann" ;

    public EchoTagHandler() { }

    protected String echo (SSIContext context, String var)
	{
	    if (var.equals("ABOUT_SSI")) {
		return ABOUT_MSG ;
	    } else if (var.equals("DOCUMENT_NAME")) {
		return context.file.getName();
	    } else if (var.equals("LAST_MODIFIED")) {
		return FLastModTagHandler.lastModified(context, context.file);
	    } else if (var.equals("DATE_GMT")) {
		return context.format(new Date());
	    } else {
		return "(none)"  ;
	    }
	} // echo

    /**
     * actually perform the action associated with this tag.
     */
    public void executeTag (ParseContext context) 
	throws IOException {
	
	final String var = parameters.value(VAR_PARAM, null);
	if (var == null) {
	    throw new IOException("no VAR parameter!");
	}
	ServletOutputStream out = context.getServletResponse().getOutputStream();
	out.print(echo((SSIContext) context, var));
    }
}
