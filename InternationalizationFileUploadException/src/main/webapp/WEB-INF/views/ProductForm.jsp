<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>

<style type="text/css">
@import url(resources/css/main.css);
</style>
</head>
<body>

	<div id="global">
		Language : <a href="?language=en">English</a>|<a href="?language=ne_NP">Nepali</a>
		<form:form modelAttribute="product" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label for="name"><spring:message code="addProduct.form.name.label"/></label></td>
				<td><form:input id="name" path="name" type="text"></form:input>
					<form:errors path="name" />
				</td>
			</tr>
			<tr>
				<td><label for="description"><spring:message code="addProduct.form.description.label"/></label></td>
				<td><form:input id="description" path="description" type="text"></form:input>
					<form:errors path="description" /></td>
			</tr>
			<tr>
				<td><label for="price"><spring:message code="addProduct.form.price.label"/></label></td>
				<td><form:input id="price" path="price" type="text"></form:input>
					<form:errors path="price" /></td>
			</tr>
			<tr>
				<td><label for="productImage"><spring:message code="addProduct.form.productImage.label"/></label></td>
				<td><form:input id="productImage" path="productImage" type="file"/>
					<form:errors path="productImage" /></td>
			</tr>
			<tr>
				<td><input type="reset" id="btnReset" value="Reset" /></td>
				<td><input type="submit" id="btnAdd" value="Add Product" /></td>
			</tr>
		</table>
			
		</form:form>
	</div>
</body>
</html>
