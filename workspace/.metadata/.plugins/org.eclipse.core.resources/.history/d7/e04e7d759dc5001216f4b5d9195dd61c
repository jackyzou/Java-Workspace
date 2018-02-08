<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="skyblue">
<center>
 <html:form action="/Login" >
            <table>
                <tr>
                    <td>
                        User name :
                    </td>
                    <td>
                        <html:text  property="username" />
                    </td>
                    <td>
                        <html:errors  property="username" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Password :
                    </td>
                    <td>
                        <html:password   property="password" />
                    </td>
                    <td>
                        <html:errors  property="password" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <html:submit/>&nbsp;&nbsp;
                        
                       <html:reset/>&nbsp;&nbsp;<html:reset value="New User?" onclick ="javascript:window.location='Registration.jsp'"/>
                    </td>
                </tr>
               
            </table>
        </html:form>
		</center>       
 </body>
 </html>