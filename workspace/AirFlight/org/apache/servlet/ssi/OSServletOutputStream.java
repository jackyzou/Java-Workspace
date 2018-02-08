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

/**
 * an ServletOutputStream which delegates to
 * a normal OutputStream.
 * The Java Api creators missed to provide a
 * constructor ServletOutputStream (OutputStream os).
 * This is needed for piping the Output through
 * a compressed output Stream (either gzip or zip).
 */
final public class OSServletOutputStream 
    extends ServletOutputStream {
    private OutputStream out;
    private long written;

    /**
     * Constructs a new servlet output stream, wrapping the specified output
     * stream.
     *
     * @param stream The output stream to be wrapped
     */
    public OSServletOutputStream(OutputStream out)
	throws IOException {
	this.out = out;
	written = 0;
    }

    /* default access */ long size () {
	return written;
    }

    /**
     * close underlaying output stream.
     * @exception IOException if an input/output error occurs
     */
    public void close() throws IOException {
	out.close();
    }

    /**
     * Flushes this output stream and forces any unbuffered output bytes to
     * be written out.
     *
     * @exception IOException if an input/output error occurs
     */
    public void flush() throws IOException {
	out.flush();
    }


    /**
     * Write the specified byte to this output stream.
     *
     * @param b The byte to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void write(int b) throws IOException {
	out.write(b);
	written++;
    }


    /**
     * Writes the contents of the specified buffer to the output stream.
     *
     * @param b The buffer to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void write(byte b[]) throws IOException {
	out.write(b);
	written += b.length;
    }


    /**
     * Writes <code>len</code> bytes from the specified byte array,
     * starting at offset <code>off</code> to this output stream.
     *
     * @param b The buffer containing bytes to be written
     * @param off The starting offset (zero relative)
     * @param len The number of bytes to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void write(byte b[], int off, int len) throws IOException {
	out.write(b, off, len);
	written += len;
    }
}
