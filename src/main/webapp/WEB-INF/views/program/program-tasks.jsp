<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="getParticipantsUrl" value="participants/getAllParticipantsAsOptions" />
<c:url var="getProgramByParticipantIdUrl" value="programs/getProgramByParticipantIdAsOptions" />
<c:url var="getProgramByIdUrl" value="programs/getProgramById" />

<script type="text/javascript">
	$(document).ready(function() {
		function createOptions(component, options) {
			var html = '<option value=""></option>';
            for (var i = 0; i< options.length; i++) {
                html += '<option value="' + options[i].Value + '">' + options[i].DisplayText + '</option>';
            }
            $(component).html(html);
		}
		
 		$.post(
			'${getParticipantsUrl}', {
				participantId: $('#participant').val(), 
				ajax: 'true'
			}, function(data) {
                createOptions('#participant', data.Options);
            }, "json"
        );
		
	 	$('#participant').change(function() {
	 		$.post(
 				'${getProgramByParticipantIdUrl}', {
 					participantId: $('#participant').val(), 
 					ajax: 'true'
				}, function(data) {
					createOptions('#program', data.Options);
 	            }, "json"
 	        );
		});
	 	
	 	$("#program").change(function() {
	 		var programId = $('#program').val();
	 		$.post(
 				'${getProgramByIdUrl}', {
 					programId: $('#program').val(),
 					ajax: 'true'
				}, function(data) {
					console.log(data);
 	                $('#program').html(data);
 	                $('#programTasksTableContainer').jtable('load', {programId: programId});
 	            }, "json"
 	        );
	 	});
	 	
	 	
	});
</script>
<div align="center" style="margin: 20px;">
	<div class="search-box">
		<label for="participant">Participant</label>
		<select id="participant" style="min-width: 200px"></select>
		<label for="program">Program</label>
		<select id="program" style="min-width: 200px"></select>
	</div>
	<div class="info-div">
		<div id="output">
		
		</div>
	</div>
	<div id="programTasksTableContainer">
	</div>
</div>