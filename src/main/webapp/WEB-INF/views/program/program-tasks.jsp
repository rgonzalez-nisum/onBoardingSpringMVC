<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="getProgramByParticipantIdUrl" value="programs/getProgramByParticipantId" />
<c:url var="getProgramByIdUrl" value="programs/getProgramById" />

<script type="text/javascript">
	$(document).ready(function() {
	 	$('#participant').change(function() {
	 		$.getJSON(
 				'${getProgramByParticipantIdUrl}', {
 					participantId: $('#participant').val(), 
 					ajax: 'true'
				}, function(data) {
 	                var html = '<option value=""></option>';
 	                var len = data.length;
 	                for (var i = 0; i< len; i++) {
 	                    html += '<option value="' + data[i].value + '">' + data[i].displaytext + '</option>';
 	                }
 	                $('#program').html(html);
 	            }
 	        );
		});
	 	
	 	$("#program").change(function() {
	 		var programId = $('#program').val();
	 		$.getJSON(
 				'${getProgramByIdUrl}', {
 					programId: programId, 
 					ajax: 'true'
				}, function(data) {
 	                $('#program').html(data);
 	                $('#programTasksTableContainer').jtable('load', {programId: programId});
 	            }
 	        );
	 	});
	});
</script>
<div align="center" style="margin: 20px;">
	<div class="search-box">
<%-- 		<form:form method="POST" commandName="customerForm"> --%>
			<fieldset>
				<label for="participant">Participant</label>
				<form:select id="participant" path="participant" items="${participantOptions}" />
				<br/>
				<label for="program">Program</label>
				<select id="program" style="width: 200px"></select>
			</fieldset>
<%-- 		</form:form> --%>
	</div>
	<div class="info-div">
		<div id="output">
		
		</div>
	</div>
	<div id="programTasksTableContainer">
	</div>
</div>