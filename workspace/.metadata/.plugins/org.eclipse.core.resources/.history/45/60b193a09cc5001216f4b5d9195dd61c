<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.io.*" %>
<%@ page import="
 javax.servlet.http.HttpServletResponse" %>
<%@ page import="
 javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <% 
             
        	  Connection con=null;
        	   
        	 

       		   Class.forName("oracle.jdbc.driver.OracleDriver");
       		   con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","tiger");
       		   System.out.println("connected");
       		   Statement   st=con.createStatement();
       		   
       		  ResultSet rs=  st.executeQuery("select * from flightinfo");
        %>
       		
          
        
<html>
<head>













<title>flight Info</title>
</head>
<body>
 <center><h3>Flight Information</h3></center>
    <table align=center border=1 bordercolor=orange>
  <tr>
	 <th>Flight Number</th>
	 <th>Flight Name</th>
	 <th>Departure Time</th>
	 <th>Arrival Time</th>
	 <th>Original Place</th>
	 <th>Destination Place</th>
	 <th>Seats</th>
	 <th>Country</th>
	 </tr>
	 <%
	  while(rs.next())
	   {
	%>
	<tr>
	  <td><%=rs.getString(1)%></td>
	  <td><%=rs.getString(2)%></td>
	  <td><%=rs.getString(3)%></td>
	  <td><%=rs.getString(4)%></td>
	  <td><%=rs.getString(5)%></td>
	  <td><%=rs.getString(6)%></td>
	  <td><%=rs.getInt(7)%></td>
	  <td><%=rs.getString(8)%></td>
	</tr>
	<%
	  }
	%>
   </table>
   </body>
  </html>        