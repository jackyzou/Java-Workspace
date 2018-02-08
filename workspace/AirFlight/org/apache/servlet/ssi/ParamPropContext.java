package org.apache.servlet.ssi;

import java.io.File;
import java.util.Vector;
import javax.servlet.http.*;

/**
 *  This class represents an SSI context.
 *  Its lifetime is one interpretation of a given page.
 *  <br>
 *  HREFParameterPropagators save the GET-String to
 *  be appended here.
 *  Additional data should be handled here. 
 *  @author H. Zeller
 *  @version $Revision: 1.3 $ $Date: 1999/06/22 22:50:18 $
 *  @see org.apache.servlet.ssi.SSI
 */
public class ParamPropContext 
    extends SSIContext {
    
    public ParamPropContext (File file, 
			     HttpServletRequest req,
			     HttpServletResponse res,
			     PageParser parser) {
	super (file, req, res, parser);
    }

    public byte[] hrefParameterAppend = null;
    public boolean hrefRewriteNecessary = false;
}
