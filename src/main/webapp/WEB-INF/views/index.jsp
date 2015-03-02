<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="indexContainer" align="center">
	<ul class="wrapper">
		<li class="box">
			<div>
				<a href="<c:url value="/participants"/>" title="Participants">
					<img src="<c:url value="/resources/icons/index-participants.png"/>">
				</a>
			</div>
		</li>
		<li class="box">
			<div>
				<a href="<c:url value="/programs"/>" title="Programs">
					<img src="<c:url value="/resources/icons/index-programs.png"/>">
				</a>
			</div>
		</li>
		<li class="box">
			<div>
				<a href="<c:url value="/program-tasks"/>" title="Tasks">
					<img src="<c:url value="/resources/icons/index-tasks.png"/>">
				</a>
			</div>
		</li>
		<li class="box">
			<div>
				<a href="<c:url value="/reports/getParticipantTasks"/>" target="_blank" title="Progress Report">
					<img src="<c:url value="/resources/icons/index-reports-pdf.png"/>">
				</a>
			</div>
		</li>
	</ul>
</div>