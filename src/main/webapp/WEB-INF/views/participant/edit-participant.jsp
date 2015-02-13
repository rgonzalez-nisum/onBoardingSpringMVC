<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<style>
			.error {
				color: #ff0000;
			}
			
			.errorblock {
				color: #000;
				background-color: #ffEEEE;
				border: 3px solid #ff0000;
				padding: 8px;
				margin: 16px;
			}
		</style>
	</head>
	<body>
		<h2>Nisum On-Boarding: New participant</h2>
		<form:form method="POST" commandName="participant">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Lastname:</td>
					<td><form:input path="lastname" /></td>
					<td><form:errors path="lastname" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Position:</td>
					<td><form:select path="position">
							<form:options items="${positions}" />
						</form:select></td>
					<td><form:errors path="position" cssClass="error" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit"/></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>