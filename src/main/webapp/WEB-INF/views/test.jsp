<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JQuery JTable integration with Spring MVC3 </title>
        <c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />  
        
        <%-- JQuery --%>
        <script src="${baseURL}/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${baseURL}/resources/js/jquery-ui-1.10.0.min.js" type="text/javascript"></script>
        
        <%-- JTable --%>
        <link href="${baseURL}/resources/js/jtable.2.4.0/themes/metro/blue/jtable.css" rel="stylesheet" type="text/css" />       
        <script src="${baseURL}/resources/js/jtable.2.4.0/jquery.jtable.js" type="text/javascript"></script>
        
        <link href="${baseURL}/resources/css/jquery-ui-1.10.0.css" rel="stylesheet" type="text/css" />
        
        <script src="${baseURL}/resources/js/participantsJTable.js" type="text/javascript"></script>
    </head>
    <body>
        <div>       
             <div id="participantTableContainer" style="width:99%;"></div>
        </div>
    </body>
</html>