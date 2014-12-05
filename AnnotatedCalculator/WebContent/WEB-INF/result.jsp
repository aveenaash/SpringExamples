<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/mystyle.css">
<meta charset="ISO-8859-1">
</head>
<body>
<h4>Calculator RESULTS</h4>
	<form action="" method="get">
		<input name="add1" type="text" class="textBox" value=<c:out value="${calculatorResult.add1}"/>>+
		<input name="add2" type="text" class="textBox" value=<c:out value="${calculatorResult.add2}"/>>=
	
    <c:choose>
	    <c:when test="${calculatorResult.addResult gt  0}">
			<input name="sum" type="text" class="textBoxBlue" readonly value=<c:out value="${calculatorResult.addResult}"/>>
	    </c:when>
	    <c:when test="${calculatorResult.addResult lt  0}">
			<input name="sum" type="text" class="textBoxRed" readonly value=<c:out value="${calculatorResult.addResult}"/>>
	    </c:when>
	    <c:otherwise>
			<input name="sum" type="text" class="textBox"readonly  value=<c:out value="Zero"/>>
	    </c:otherwise>
	</c:choose>

		<br> 
 
		<input name="mul1" type="text" class="textBox" readonly value=<c:out value="${calculatorResult.mult1}"/>>*
		<input name="mul2" type="text" class="textBox" readonly value=<c:out value="${calculatorResult.mult2}"/>>=
		<input name="result" type="text" class="textBox" readonly value=<c:out value="${calculatorResult.multResult}"/>>
		<br>

		<br>
			<input type="submit" value="Try Again" />
		</form>
	
</body>
</html>