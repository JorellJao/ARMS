<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<p>
		THIS IS WHERE YOU ADD TWO NUMBERS
		<spring:message code="message.profile.info1"/><BR />
		<spring:message code="message.profile.info2"/><BR />
		
		<form action="${pageContext.request.contextPath}/modulename/addtwonumbers" method="GET">
			First Number : <input type="text" name="firstNumber"/><br/>
			Second Number : <input type="text" name="secondNumber"/><br/>
			
			<button type="submit">SUBMIT ME!!!!</button>
		</form>
	</p>
</div>
