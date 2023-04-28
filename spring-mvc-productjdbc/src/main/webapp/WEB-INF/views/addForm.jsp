<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Product</h1>
<form action="addProduct" method="post">
	Enter ProductName<input type="text" name="productName"><br>
	Enter Brand<input type="text" name="brand">
	Enter category<input type="text" name="category"><br>
	Enter Price<input type="text" name="price">
	<input type="submit" value="Add Product">
</form>
</body>
</html>