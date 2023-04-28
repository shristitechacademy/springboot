<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${product }
<h1>Update Product</h1>
<form action="updateProduct" >
	Enter ProductName<input type="text" name="productName" readonly value="${product.productName }"><br>
	Enter Brand<input type="text" name="brand" readonly value="${product.brand}"><br>
	Enter ProductId<input type="text" name="productId" readonly value="${product.productId}"><br>
	Enter category<input type="text" name="category"  readonly value="${product.category}"><br>
	Enter Price<input type="text" name="price" value="${product.price}"><br>
	<input type="submit" value="Update Product">
</form>
</body>
</html>