<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<h1>Registration Form</h1>
	<br/>
	<form:form modelAttribute="student">
		<table>
			<tr>
				<td><label for="id"><spring:message code="register.form.id.label"></spring:message> </label></td>
				<td><form:input id="id" path="id" type="text"></form:input>
					<form:errors path="id" />
				</td>
			</tr>
			<tr>
				<td><label for="firstName">First Name</label></td>
				<td><form:input id="firstName" path="firstName" type="text"></form:input>
					<form:errors path="firstName" />
				</td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name</label></td>
				<td><form:input id="lastName" path="lastName" type="text"></form:input>
					<form:errors path="lastName" />
				</td>
			</tr>
			<tr>
				<td><label for="email">Email</label></td>
				<td><form:input id="email" path="email" type="text"></form:input>
					<form:errors path="email" />
				</td>
			</tr>
			<tr>
				<td><label for="gender">Gender</label></td>
				<td><form:radiobutton path="gender" value="Male" />Male <form:radiobutton
						path="gender" value="Female" />Female
					<form:errors path="gender" />
				</td>
			</tr>
			<tr>
				<td><label for="birthday">Birthday</label></td>
				<td><form:input id="birthday" path="birthday" type="text"></form:input>
					<form:errors path="birthday" />
				</td>
			</tr>
			<tr>
				<td><label for="phone">Phone</label></td>
				<td><form:input size="3" id="phone.area" path="phone.area" type="text"></form:input>-
					<form:errors path="phone.area" />
					<form:input size="3" id="phone.prefix" path="phone.prefix" type="text"></form:input>-
					<form:errors path="phone.prefix" />
					<form:input size="3" id="phone.number" path="phone.number" type="text"></form:input>
					<form:errors path="phone.number" /></td>
			</tr>
		</table>
		<input type="submit" id="btnAdd" value="Add" />
	</form:form>
</body>
</html>