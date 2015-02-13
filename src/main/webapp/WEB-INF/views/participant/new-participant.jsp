<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<script type="text/javascript">
	$(document).ready(function() {
		$('#newParticipantForm').submit(function(event) {
			var name = $('#name').val();
			var lastname = $('#lastname').val();
			var position = $('#position').val();
			var email = $('#email').val();
			var json = { "name" : name, "lastname" : lastname, "position": position, "email": email};
			 
			$.ajax({
				url: $("#newParticipantForm").attr("action"),
				data: JSON.stringify(json),
				type: "POST",
				  	
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				
				success: function(participant) {
					var respContent = "";
					  		
					respContent += "<span class='success'>Participant successfully registered: [";
					respContent += participant.name + " : ";
					respContent += participant.lastname + " : " ;
					respContent += participant.position + " : " ;
					respContent += participant.email + "]</span>";
					  		
					$("#participantFromResponse").html(respContent);   		
				}
			});
			     
			event.preventDefault();
		});
	});   
</script>
<div id="container">
	<h1>Participant registration</h1>
	<div>
		<p>Here you can register new participant:</p>
		<div id="participantFromResponse"></div>
	</div>
</div>
<div>
	<form:form id="newParticipantForm" action="${pageContext.request.contextPath}/participants/register.json" commandName="participant">
		<table>
			<tbody>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" required="required" /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><form:input path="lastname" required="required" /></td>
				</tr>
				<tr>
					<td>Position:</td>
					<td>
						<form:select path="position" required="required">
							<form:options items="${positions}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" required="required" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"/></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</div>