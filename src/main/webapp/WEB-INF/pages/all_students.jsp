<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red;text-align: center;">All Student Details</h1><br><br>

<c:choose>
	<c:when test="${!empty listDTO }">
		<table border="1" bgColor="yellow" style="text-align: center;" >
			<tr>
				<th>SrNo</th>
				<th>Student Number</th>
				<th>Name</th>
				<th>Address</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Operations</th>
			</tr>
			<c:forEach items="${listDTO }" var="dto">
				<tr>
					<td>${dto.srno }</td>
					<td>${dto.sno }</td>
					<td>${dto.sname }</td>
					<td>${dto.address }</td>
					<td>${dto.mobile }</td>
					<td>${dto.email }</td>
					<td><a href="update_student.temp?sno=${dto.sno}"><img alt="update" src="images/update.jpg" width="70" height="40"></a>
					&nbsp;
					<a href="delete_student.temp?sno=${dto.sno}"><img alt="delete" src="images/delete.jpg" width="70" height="40"></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	
</c:choose>
<p style="color: red;text-align: center;background-color: yellow;">${resMsg}</p>
<br><br>
<a href="register.temp"><img src="images/add.jpg" width="50" height="50" ></a>
<a href="welcome.temp"><img alt="home" src="images/home.jpg" width="50" height="50"></a>