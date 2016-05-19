<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="questions">
		<center>
			<h1>Kwestyeeeens</h1>
			<form id="questionForm">
				
					<c:forEach var="question" items="${questionlist}">
						<div class="questionlist">
							<input type="checkbox" name="questionid" class="checkbx"
								value="${question.id.id}">
							<label>${question.questionLabel}</label>
							<button type="button" onclick="showAnwers('')">answers</button>
							<div id="${question.id.id}questionAnswers">
							
							</div>
						</div>
					</c:forEach>
				
				<button type="button"
					onclick="executeDelete('${pageContext.request.contextPath}/exam/deleteexam')">delete
					exams</button>
			</form>
		</center>
	</div>
</body>
</html>