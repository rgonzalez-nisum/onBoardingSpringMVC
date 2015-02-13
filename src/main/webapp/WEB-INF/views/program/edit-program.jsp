<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div align="center" style="width: 100%">
	<div>
		<table style="width: 600px">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Last name</th>
					<th>Position</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="participant" items="${participants}">
					<tr>
						<td>${participant.id}</td>
						<td>${participant.name}</td>
						<td>${participant.lastname}</td>
						<td>${participant.position}</td>
						<td>${participant.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>