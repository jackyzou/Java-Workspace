package com;

import java.sql.*;
//import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TransAction extends Action 
{


    private final static String SUCCESS = "tsuccess";
 
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
    {
    	
    	TransForm tgForm = (TransForm) form;
    	
        	try {
        		
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
       		   Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
       		   System.out.println("connected");
       		    Statement  st=con.createStatement();
       		 System.out.println("inserted");
     	  st.executeQuery("insert into transaction values ('"+tgForm.getCredit_num()+"','"+tgForm.getCredit_type()+"','"+tgForm.getPin_num()+"')");
       		
       	  }catch(Exception s)
       	     {
        	System.out.println(s);
              }
        return mapping.findForward(SUCCESS);
    }
}
      
      
        
        
      
	
	