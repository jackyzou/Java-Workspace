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

import java.util.Date;
import java.text.DateFormat;
import java.io.File;
import java.util.Vector;
import javax.servlet.http.*;

/**
 *  This class represents an SSI context.
 *  Its lifetime is one interpretation of a given page.
 *  <br>
 *  An SSI context contains different settings 
 *  associated with a file: date and size formats.
 *  The context is used by most instructions 
 *  and is set by the <code>config</code> 
 *  SSI instruction.<br>
 *  Additional data should be handled here. 
 *  @author Matthias Wiesmann
 *  @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:28 $
 *  @see org.apache.servlet.ssi.SSI
 */

public class SSIContext 
    extends AbstractParseContext
{

    public SSIContext(File file, 
		      HttpServletRequest req,
		      HttpServletResponse res,
		      PageParser parser)
    {
	super (req, res);
	this.file = file;
	this.parser = parser;
    }

    /** The default <code>DateFormat</code> */
    public DateFormat date_format = DateFormat.getDateTimeInstance();
    /** The file that is being handled */
    public File file ;
    /** Whether size should be truncated to bytes */
    public boolean abbrev = false ;
    /** The page Parser */
    public PageParser parser;

    /** Formats a Date according to the current context 
     *  @param date the date to format
     *  @return a string containing the formated date
     */ 
    public String format(Date date)
	{
	    return date_format.format(date);
	} // format

} // SSIContext 

