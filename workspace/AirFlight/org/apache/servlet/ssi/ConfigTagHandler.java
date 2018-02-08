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
 * $Id: ConfigTagHandler.java,v 1.2 1999/06/09 22:41:25 hzeller Exp $
 */
package org.apache.servlet.ssi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.StringTokenizer;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.java.util.SGMLTag;
import org.apache.java.io.PositionReader;

/**
 *  This class defines the SSI <code>config</code> instruction.
 *  All configuration instruction affect the SSI context 
 *  object associated with the page.<br>
 *  The following intructions are supported:
 *  <ul><li><code>timefmt</code><li><code>sizefmt</code></ul>
 *  
 *  @see SSIContext
 *  @author Matthias Wiesmann
 *  @version $Revision: 1.2 $ $Date: 1999/06/09 22:41:25 $
 */

public class ConfigTagHandler 
    extends SSITagHandler {

    protected final static String BYTE_SIZE = "BYTE" ;
    protected final static String ABBREV_SIZE = "ABBREV" ;
    protected final static String TIME_FORMAT = "TIMEFMT" ;
    protected final static String SIZE_FORMAT = "SIZEFMT" ;

    /** The marker used by SSI formatting */
    protected final static String FORMAT_MARK = "%" ;

    /** This property table contains the translation sequence for 
     *  ssi to java.text formatting
     *  <br><strong>Note:</strong> the translation is not perfect...
     *  @see java.text.SimpleDateFormat
     */ 
    protected static Properties translate ;
    
    static {
	translate = new Properties();
	translate.put("a","EEE");
	translate.put("A","EEEE");
	translate.put("b","MMM");
	translate.put("h","MMM");
	translate.put("B","MMMM");
	translate.put("d","dd");
	translate.put("D","MM/dd/YY");
	translate.put("e","d");
	translate.put("H","HH");
	translate.put("I","hh");
	translate.put("j","E");
	translate.put("m","M");
	translate.put("M","m");
	translate.put("p","a");
	translate.put("r","hh:mm:ss a");
	translate.put("S","s");
	translate.put("T","HH:mm:ss");
	translate.put("U","w");
	translate.put("W","w");
	translate.put("w","E");
	translate.put("y","yy");
	translate.put("Y","yyyy");
	translate.put("z","z");
    } // static initializer

    /** Translates a SSI time/format code into  a <code>java.text</code> format
     *  @param c the SSI character following the <code>%</code>
     *  @return a text sequence suitable for use with SimpleDateFormat
     */

    protected static String translateCode(char c)
	{
	    final String text = ""+c ;
	    final String result = translate.getProperty(text);
	    if (result== null) return "" ;
	    return result ;
	} // translateCode

    /** Checks if a string contains any characters.<br>
     *  Used for translating text.
     *  @param text the text to check
     *  @return <code>true</code> if there is some text
     *  @see #translateText
     */

    protected static boolean containsText(String text)
	{
	    for(int i=0;i<text.length();i++) {
		final char c = text.charAt(i);
		if (Character.isUnicodeIdentifierPart(c)) 
		    return  true;
	    } // for 
	    return  false; 
	} // containsText

    /** Translates litteral text for use with<code>java.text</code> format.<br>
     *  If the text contains some text, quotes are added at start and end. 
     *  If not the text is return unchanged. 
     *  @param text the litteral text
     *  @return a text sequence suitable for use with SimpleDateFormat
     *  @see #containsText 
     */ 

    protected static String translateText(String text) 
	{
	   if (containsText(text)) return "'"+text+"' " ;
	   return text ;
	} // translateText

    /** Translates a SSI formatting sequence into it's java counterpart.
     *  <pre>SSI -> java.text</pre>.
     *  
     *  @param format the SSI format sequence 
     *  @return a text sequence suitable for use with SimpleDateFormat
     */

    protected static String translateFormat(String format)
	{
	    StringBuffer buffer = new StringBuffer();
	    StringTokenizer token = new StringTokenizer(format,FORMAT_MARK);
	    if (! format.startsWith(FORMAT_MARK))
		buffer.append(translateText(token.nextToken())); // first run 
	    while(token.hasMoreTokens()) {
		final String next = token.nextToken(); // the token
		final char c = next.charAt(0);         // the SSI command
		final String rest = next.substring(1); // the rest of the line
		buffer.append(translateCode(c)) ;      // the command is translated
		buffer.append(translateText(rest));    // so is the text 
	    } // while
	    return buffer.toString();
	} // translateTimeFormat

    /** Handles the <code>timefmt</code> parameter
     *  @param format the new time format (SSI format)
     */

    protected void doTimeFormat(SSIContext context, String format)
	{
	    final String text = translateFormat(format);
	    final DateFormat new_format = new SimpleDateFormat(text);
	    context.date_format= new_format ;
	} // doTimeFormat

    /** Handles the <code>sizefmt</code> parameter.
     * The following values are handled: 
     *  <ul>
     *  <li><code>abbrev_size</code> size displayed in Kilobytes.
     *  <li><code>byte_size</code> size displayed in bytes. 
     *  </ul>
     *  @param format the new size format
     */ 
    protected void doSizeFormat(SSIContext context, String format)
	{
	    if (format.toUpperCase().equals(ABBREV_SIZE)) 
		context.abbrev = true;
	    if (format.toUpperCase().equals(BYTE_SIZE)) 
		context.abbrev = false;
	} // doSizeFormat

    /**
     * actually perform the action associated with this tag.
     */
    public void executeTag (ParseContext context) 
	throws IOException {

	final String time_format = parameters.value(TIME_FORMAT, null);
	if (time_format!= null) doTimeFormat((SSIContext) context, time_format);
	final String size_format = parameters.value(SIZE_FORMAT, null);
	if (size_format!= null) doSizeFormat((SSIContext) context, size_format);
    }
}
