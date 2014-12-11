<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}<br/>
        <c:url value='/resources/images/${product.name}.jpg'/>
    </p>
<img src="<c:url value='/resources/images/${product.name}.jpg'/>" alt="image"  style = "width:50%"/>
</div>
</body>
</html>