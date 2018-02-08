<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 

   
<html>
    <head>
    </head>
    <body>    
    
    	<a href="Home.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Home</a>&nbsp;|&nbsp;
       	<a href="Aboutus.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>About Us</a>&nbsp;|&nbsp;
		<a href="Callcenter.jsp"><b><font style="font-weight:bold"" face="Times New Roman" size="3"></font></b>Airport Information</a>&nbsp;|&nbsp;
		<a href="Technology.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Airline Services</a>&nbsp;|&nbsp;
		<a href="News.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Ticket Reservation</a>&nbsp;|&nbsp;
		<a href="Quote.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Ticket Cancellation</a>&nbsp;|&nbsp;
		<a href="Feedback.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Transaction Information</a>&nbsp;|&nbsp;
		<a href="Contact.jsp"><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Contact Us</a>
		<img border="0" src="images/Airline.PNG" title="Home Page" width="900" height="500">		
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
                        <html:text   property="password" />
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