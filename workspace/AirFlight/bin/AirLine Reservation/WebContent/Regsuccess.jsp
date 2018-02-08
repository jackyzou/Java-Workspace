<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    <%@ page language="java" import=" java.util.*" %>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Registration is successfully done :<bean:write name="RegisterForm" property="username"></bean:write></h2>

<%
Random rand = new Random();
int num = rand.nextInt(1000);
//System.out.println("cust id : " + num);
%>
<h3>The customer Id is :</h3><b>JT<%=num%></b>
</body>
</html>