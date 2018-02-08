<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/Layout.jsp" flush="true">
    <tiles:put name="title" value="Airline Reservation System" />
    <tiles:put name="header" value="/Header1.jsp" />
    <tiles:put name="body" value="/body1.jsp" />
</tiles:insert>