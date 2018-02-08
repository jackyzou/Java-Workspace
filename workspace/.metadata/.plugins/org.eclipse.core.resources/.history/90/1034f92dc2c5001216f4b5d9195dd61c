package com;


import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
//import org.apache.tomcat.util.http.mapper.MappingData;

public class ReservationAction extends org.apache.struts.action.Action {
	private final static String SUCCESS = "ressuccess";
    private final static String FAILURE = "resfailure";
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
    {
       ReservationForm logForm = (ReservationForm) form;
       //String cId=loginForm.getCustid();
       String fnum=logForm.getFlightnum();
       String fname=logForm.getFlightname();
       String Fnum=null;
       String Fname=null;
       Connection con=null;
	   Statement st=null;
	   ResultSet rs=null;
    //   if(fnum.equals(Fnum)&& fname.equals(Fname))
       //{
       //ActionForward nextpage=null;
       try{
    	  
   		   Class.forName("oracle.jdbc.driver.OracleDriver");
   		   con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
   		   System.out.println("connected");
           st=con.createStatement();
           rs=  st.executeQuery("select flightnum,flightname,departure,arrival,origin,destination,seats from flightinfo where  flightnum='"+fnum+"'and flightname='"+fname+"'");
            while(rs.next())
            {
              Fnum=rs.getString("flightnum");
              Fname=rs.getString("flightname");
            }
   		 // st.executeQuery("insert into Reservation values('"+logForm.getCustid()+"','"+logForm.getFlightnum()+"','"+logForm.getFlightname()+"','"+logForm.getDeparture()+"','"+logForm.getArrival()+"','"+logForm.getOrig()+"','"+logForm.getDestination()+"','"+logForm.getSeats()+"') ");
   		 // System.out.println("inserted");
   		    
   		  
   	 }catch(Exception e)
   	     {
   		System.out.println(e);
     	  }
   	 if(fnum.equals(Fnum)&& fname.equals(Fname))
   	 {
       try{
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
   		   con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
   		   System.out.println("connected");
           st=con.createStatement(); 
           st.executeQuery("insert into Reservation values('"+logForm.getCustid()+"','"+logForm.getFlightnum()+"','"+logForm.getFlightname()+"','"+logForm.getDeparture()+"','"+logForm.getArrival()+"','"+logForm.getOrig()+"','"+logForm.getDestination()+"','"+logForm.getSeats()+"') ");
     		System.out.println("inserted");
       }catch(Exception e){}
       
       return mapping.findForward(SUCCESS);
     }
       else
       {
    	   return mapping.findForward(FAILURE);   
       }
   	 
   //  return nextpage;
}
}
