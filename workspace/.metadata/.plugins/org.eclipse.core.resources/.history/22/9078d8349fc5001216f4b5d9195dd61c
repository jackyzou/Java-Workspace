package com;

import java.sql.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends org.apache.struts.action.Action 
{


    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
    {
    	ActionForward nextpage=null;
    	 LoginForm lgForm = (LoginForm) form;
        String uname = lgForm.getUsername();
        String passwd = lgForm.getPassword();
        String unam=null;
        String password=null;
   
        	try {
        		
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
       		   Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
       		   System.out.println("connected");
       		   System.out.println("lgForm.getUsername()->"+lgForm.getUsername());
       		   System.out.println("lgForm.getpassword()->"+lgForm.getPassword());
               Statement  st=con.createStatement();
           
     	ResultSet rs=  st.executeQuery("select username ,password from register where username ='"+uname+"'and password='"+passwd+"'");
       		while (rs.next()){
       			 unam=rs.getString(1);
       			 password =rs.getString(2);
       		  }
       	  }catch(Exception s)
       	     {
        	System.out.println(s);
              }
        	if(uname.equals(unam)&& passwd.equals(password)) {
        		nextpage= mapping.findForward(SUCCESS);
        	 
        }
      
        else{
        	nextpage= mapping.findForward(FAILURE);
         }
        
        
        return nextpage;
    }
	
	}
