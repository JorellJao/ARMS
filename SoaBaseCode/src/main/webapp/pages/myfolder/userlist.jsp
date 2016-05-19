<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<jsp:include page="../common/css.jsp" />
</head>
<div class="container">
	<div id="header">
		<jsp:include page="../common/header.jsp" />
	</div>
	<div id="body">
		<form
			action="${pageContext.request.contextPath}/modulename/${myFunction eq 'edit' ? 'edituser':'adduser'}"
			method="POST">
			User ID : <input type="text" name="userid" value="${myUser.uid}" /><br />
			First Name : <input type="text" name="firstname"
				value="${myUser.fname}" /><br /> Last Name : <input type="text"
				name="lastname" value="${myUser.lname}" /><br /> Age : <input
				type="text" name="age" value="${myUser.age}" /><br /> Gender : <input
				type="text" name="gender" value="${myUser.gender}" /><br />
			Password : <input type="text" name="password"
				value="${myUser.password}" /><br />

			<button type="submit">SUBMIT ME!!!!</button>
		</form>

		<hr />
		<hr />
		<form action="${pageContext.request.contextPath}/modulename/upload"
			enctype="multipart/form-data" method="POST">
			FILE: <input type="file" name="uploadFiles" /><br />
			<button type="submit">UPLOAD ME!!!!</button>
		</form>

		<hr />
		<hr />

		<form
			action="${pageContext.request.contextPath}/modulename/deleteuser"
			id="moduleForm" method="POST">
			<div id="tableDiv">
				<table border="2">
					<tr>
						<td><input type="checkbox" onclick="checkAll(this.checked);" /></td>
						<td>UID</td>
						<td>FNAME</td>
						<td>LNAME</td>
						<td>AGE</td>
						<td>ADDRESS</td>
					</tr>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td><input type="checkbox" name="userid" value="${user.uid}"
								class="chckbx" /></td>
							<td>${user.uid}</td>
							<td><a
								href="${pageContext.request.contextPath}/modulename/loadedit?userid=${user.uid}">${user.fname}</a>
							</td>
							<td>${user.lname}</td>
							<td>${user.age}</td>
							<td>${user.address}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<button type="button"
				onclick="executeDelete('${pageContext.request.contextPath}/modulename/deleteuser')">DELETE
				ME!!!!</button>
		</form>

	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</div>
<jsp:include page="../common/js.jsp" />