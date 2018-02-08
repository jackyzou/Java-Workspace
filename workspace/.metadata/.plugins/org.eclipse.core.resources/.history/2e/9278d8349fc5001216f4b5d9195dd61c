package com;


import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
//import org.apache.tomcat.util.http.mapper.MappingData;

public class RegisterAction extends Action {
	private final static String SUCCESS = "regsuccess";
    private final static String FAILURE = "regfailure";
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
    {
       RegisterForm loginForm = (RegisterForm) form;
       String uname=null;
       String passwd=null;
       
       try{
    	   Connection con=null;
    	   Statement st=null;
    	   ResultSet rs=null;

   		   Class.forName("oracle.jdbc.driver.OracleDriver");
   		   con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
   		   System.out.println("connected");
           st=con.createStatement();
   		 rs=   st.executeQuery("insert into register values('"+loginForm.getUsername()+"','"+loginForm.getPassword()+"','"+loginForm.getFname()+"','"+loginForm.getLname()+"','"+loginForm.getEmail()+"','"+loginForm.getPhone()+"','"+loginForm.getJob()+"','"+loginForm.getAdd1()+"','"+loginForm.getAdd2()+"','"+loginForm.getCity()+"','"+loginForm.getState()+"','"+loginForm.getCountry()+"','"+loginForm.getZip()+"')");
   		 System.out.println("inserted");
   	/*	while (rs.next()){
  			 uname=rs.getString(1);
  			 passwd =rs.getString(2);
  		  }*/
   		  // System.out.println("inserted");
   		  
   	 }catch(Exception e)
   	{
   		System.out.println(e);
   	}
   
    
   	 return mapping.findForward(SUCCESS);
   }
   	 
  }
