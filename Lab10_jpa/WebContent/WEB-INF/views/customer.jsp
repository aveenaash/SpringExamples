<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="/webstorejpa/resource/js/controllers.js"></script>
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div class="row">
				
			<div class="col-md-5">
				<h3>${customer.firstName}</h3>
				<p>${customer.lastName}</p>
				<p>
					<strong>Age</strong> : ${customer.age}
				</p>
				<p>
					<strong>Eye Color</strong> : ${customer.eyeColor}
				</p>

			</div>
		</div>
	</section>
</body>
</html>
