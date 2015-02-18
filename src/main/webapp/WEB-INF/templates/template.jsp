<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascripts"/>

<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon" />
		<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon" />
	    <c:forEach var="css" items="${stylesheets}">
	        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
	    </c:forEach>
	    <c:forEach var="js" items="${javascripts}">
	        <script type="text/javascript" src="<c:url value="${js}"/>"></script>
	    </c:forEach>
	</head>
    <body>
    	<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="content" align="center">
			<tiles:insertAttribute name="content" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#<tiles:insertAttribute name="menu-active-option"/>').addClass('active');
		});
	</script>
</html>
