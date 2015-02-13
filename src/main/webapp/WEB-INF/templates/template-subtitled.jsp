<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true"/></title>
		<link rel="icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon" />
		<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>" />
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	</head>
    <body>
    	<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="subtitle" class="subtitle">
			<tiles:insertAttribute name="subtitle" />
		</div>
		<div id="content" align="center">
			<tiles:insertAttribute name="content" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>