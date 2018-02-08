<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body style="background-color: skyblue">
          <center><h3>Reservation</h3></center>
    <center>
        <html:form action="/reserv" >
            <table>
                <tr>
                    <td>
                        Customer Id :
                    </td>
                    <td>
                        <html:text property="custid"/>
                    </td>
                    <td>

                <font color="red">  <html:errors property="custid" /> </font>


                    </td>
                </tr>
                <tr>
                    <td>
                        Flight Number :
                    </td>
                    <td>
                        <html:text property="flightnum"/>
                    </td>
                    <td>
                <font color="red">  <html:errors property="flightnum" /> </font>
            </td>

                </tr>
                <tr>
                    <td>
                        Flight Name :
                    </td>
                    <td>
                        <html:text property="flightname"/>
                    </td>
                    <td>
                <font color="red">  <html:errors property="flightname" /> </font>
            </td>

                </tr>
                <tr>
                    <td valign="top">
                        Departure Date :
                    </td>
                    <td>
                        <html:text property="departure"/>
                    </td>
                    <td>
                <font color="red">  <html:errors property="departure" /> </font>
              </td>

                </tr>
                <tr>
                    <td>
                        Arrival Date:
                    </td>
                    <td>
                        <html:text property="arrival"/>
                    </td>
                    <td>
                <font color="red">  <html:errors property="arrival" /> </font>
            </td>
            </tr>
               <tr>
                    <td>
                        Origin Place :
                    </td>
                    <td>
                        <html:text property="orig"/>
                    </td>
                    <td>
               
                   </td>
                </tr>
                 <tr>
                    <td>
                        Destination place:
                    </td>
                    <td>
                        <html:text property="destination"/>
                    </td>
                    
                    <td>
                <font color="red">  <html:errors property="destination" /> </font>
            </td>
            </tr>
             <tr>
                    <td>
                        Number of Seats:
                    </td>
                    <td>
                        <html:text property="seats"/>
                    </td>
                    <td>
                <font color="red">  <html:errors property="seats" /> </font>
            </td>
            </tr>
                <tr>
                    <td>
                  <center><html:submit value="Submit"/>&nbsp;&nbsp;&nbsp;<html:reset value="reset"/></center>
                    </td>
                </tr>
            </table>
        </html:form>
        </center>
    </body>
</html>
