<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<a href="<c:url value="/"/>">
		<img id="logo" alt="Nisum Technologies" title="Nisum Technologies" src="<c:url value="/resources/images/logo.png"/>">
	</a>
	<div id="menu">
		<ul>
			<li id="option-home"><a href="<c:url value="/"/>">Home</a></li>
			<li id="option-participant"><a href="<c:url value="/participants"/>">Participants</a></li>
			<li id="option-program"><a href="<c:url value="/programs"/>">Programs</a></li>
			<li id="option-task"><a href="<c:url value="/program-tasks"/>">Program Tasks</a></li>
		</ul>
	</div>
</div>

