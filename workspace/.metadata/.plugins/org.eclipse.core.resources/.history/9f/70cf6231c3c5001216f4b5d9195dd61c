package com;
import java.sql.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CancellationAction extends org.apache.struts.action.Action 
{


    private final static String SUCCESS = "csuccess";
    private final static String FAILURE = "cfailure";
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
    {
    	ActionForward nextpage=null;
    	 CancellationForm lg1Form = (CancellationForm) form;
       String C_id = lg1Form.getCust_id();
       String Fl_num = lg1Form.getFlight_num();
       String Fl_name = lg1Form.getFlight_name();
       String Org=lg1Form.getOrg();
       String Dest=lg1Form.getDestination();
       String Arv_Time=lg1Form.getArriv_time();
       String Dep_Time=lg1Form.getDep_time();
      // String S_num = lgForm.getSeat_num();
       
       String c_id=null;
       String fl_num=null;
      String fl_name=null;
       String av_tm=null;
    String dep_tm=null;
      String Org1=null;
       String dest=null;
       ResultSet rs=null;
		 Connection  con=null;
		  Statement  st=null;
         	try {
         		 
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
       		    con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
       		   System.out.println("connected");
       		     st=con.createStatement();
       		   
             	rs=st.executeQuery("insert into cancellation values('"+lg1Form.getCust_id()+"','"+lg1Form.getFlight_num()+"','"+lg1Form.getOrg()+"','"+lg1Form.getDestination()+"','"+lg1Form.getFlight_name()+"','"+lg1Form.getDep_time()+"','"+lg1Form.getArriv_time()+"','"+lg1Form.getSeat_num()+"')");
       		    System.out.println("Values are inserted");
       		    
             	rs=  st.executeQuery("select custid,flightnum,flightname,departure,arrival,orig,destination from reservation where  custid='"+C_id+"' and flightnum='"+Fl_num+"'and flightname='"+Fl_name+"'and departure='"+Dep_Time +"'and arrival='"+Arv_Time+"'and orig='"+Org+"'and destination='"+ Dest+"'");

       		while (rs.next())
       		{
       			 c_id =rs.getString("custid");
       			 fl_num  =rs.getString("flightnum");
       			 fl_name  =rs.getString("flightname");
       			 av_tm=rs.getString("departure");
       			 dep_tm=rs.getString("arrival");
       			 Org1=rs.getString("orig");
       			 dest=rs.getString("destination");
       		 }
       		System.out.println("Executing");

         	}
         	catch(Exception e)
         	{
         		System.out.println(e);
           		//System.out.println("Correct");

         	}
       		
       		if(C_id.equals(c_id) && Fl_num.equals(fl_num)) 
        	{
       			
       		 nextpage= mapping.findForward(SUCCESS);
             }
       	 else
        {
        	nextpage= mapping.findForward(FAILURE);
         }
        
        
        return nextpage;
    }
	
	}

