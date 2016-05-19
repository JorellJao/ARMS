<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exams</title>
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="lib/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/media-queries.css" />
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>


	<form id="examForm">
		<div id="addexamForm">
			<table>
				<tr>
					<td><label>Exam name</label></td>
					<td><input type="Text" name="examName"></td>
				</tr>
			</table>
		</div>
		<br> <button type="button" onclick="executeAdd('${pageContext.request.contextPath}/exam/addexam')">add</button>
	</form>
	<br>


	<h1>View Exams</h1>
	<br>

	<form id="examlistForm">
		<div id="examTableDiv">
			<table>
				<tr>
					<td><input type="checkbox" onclick="checkAll(this.checked);"></td>
					<td>Exam Name - ${examlist.size()}</td>
				</tr>
				<c:forEach var="exams" items="${examlist}">
					<tr>
						<td><input type="checkbox" name="examid"
							value="${exams.id.id}" class="checkbx"></td>
						<td>${exams.id.name}</td>
						<td>
						<a href="${pageContext.request.contextPath}/question/showquestions?Eid=${exams.id.id}">view</a>
						</td>
						<td>
						<button type="button" onclick="executeRename('${pageContext.request.contextPath}/exam/loadrename?Eid=${exams.id.id}')" > rename </button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<button type="button"
			onclick="executeDelete('${pageContext.request.contextPath}/exam/deleteexam')">delete
			exams</button>
	</form>
	
	<div id="renameDiv">
		<form id="rename" action="${pageContext.request.contextPath}/exam/renameexam?Eid=${idtorename}">
			
		</form>
	</div>
</body>
<script src="lib/js/jquery-1.10.1.min.js"></script>
<script src="lib/js/bootstrap.min.js"></script>
<script src="js/common.js"></script>
<script src="lib/js/jquery.blockUI.js"></script>

<jsp:include page="../common/js.jsp" />
</html>