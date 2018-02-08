package com;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author hari
 */
public class linkAction extends DispatchAction {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
   
    public ActionForward home(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("home");

    }
     public ActionForward aboutus(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("aboutus");

    }
      public ActionForward airport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("airport");

    }
       public ActionForward count(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("flightinfo");

    }
        public ActionForward reservation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("reservation");

    }
        public ActionForward cancellation(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response)
                throws Exception {
            return mapping.findForward("cancellation");

        }
        public ActionForward transaction(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response)
                throws Exception {
            return mapping.findForward("transaction");

        }
         
          public ActionForward contactus(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("contactus");

    }
}