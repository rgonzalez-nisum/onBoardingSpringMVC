<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header">
	<img id="logo" alt="Nisum Technologies" title="Nisum Technologies" src="${pageContext.request.contextPath}/resources/images/logo.png">
	<div id="menu">
		<ul>
			<li><a href="<c:url value="/"/>">Home</a></li>
			<li><a href="<c:url value="/participants.html"/>">Participants</a></li>
			<li><a href="<c:url value="/programs.html"/>">Programs</a></li>
		</ul>
	</div>
</div>