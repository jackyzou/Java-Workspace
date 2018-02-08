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
       		   
       		  ResultSet rs=  st.executeQuery("select * from Price");
  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Price Info</title>
</head>
<body>
<center><h3>Price Information</h3></center>
 <table align=center border=1 bordercolor=orange>
      <tr>
	 <th>Class</th>
	 <th>Customer Name</th>
	 <th>Seat Number</th>
	 <th>Price Of ticket</th>
	</tr>
	
	<%
	  while(rs.next())
	   {
	%>
	<tr>
	  <td><%=rs.getString(1)%></td>
	  <td><%=rs.getString(2)%></td>
	  <td><%=rs.getInt(3)%></td>
	  <td><%=rs.getInt(4)%></td>
	</tr>
	<%
	  }
	%>
	</table>
</body>
</html>