<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="getParticipantsUrl" value="participants/getAllParticipantsAsOptions" />
<c:url var="getProgramByParticipantIdUrl" value="programs/getProgramByParticipantIdAsOptions" />
<c:url var="getProgramByIdUrl" value="programs/getProgramById" />

<script type="text/javascript">
	$(document).ready(function() {
		$('#programTasksTableContainer').find('.jtable-toolbar-item').css({visibility: 'hidden'});
		
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
			$('#programTasksTableContainer').jtable('load', {participantId: 0, programId: 0});
			$('#programTasksTableContainer').find('.jtable-toolbar-item').css({visibility: 'hidden'});
		});
			
		$("#program").change(function() {
			var participantId = $('#participant').val();
			var programId = $('#program').val();
			$.post(
				'${getProgramByIdUrl}', {
					id: programId,
					ajax: 'true'
				}, function(data) {
					$('#programTasksTableContainer').jtable('load', {participantId: participantId, programId: programId});
					$('#programTasksTableContainer').find('.jtable-toolbar-item').css({visibility: 'visible'});
				}, "json"
			);
		});
	});
</script>
<div align="center">
	<div id="search-box">
		<div id="search-box-participant">
			<label for="participant">Participant</label>
			<select id="participant"></select>
		</div>
		<div id="search-box-program">
			<label for="program">Program</label>
			<select id="program"></select>
		</div>
	</div>
	<div id="programTasksTableContainer">
	</div>
</div>