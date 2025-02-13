<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thêm Sản Phẩm</title>
</head>
<body>
<h2>Thêm Sản Phẩm</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="products" method="post">
    <input type="hidden" name="action" value="add">

    <label for="name">Tên sản phẩm:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" step="0.01" required><br>

    <label for="quantity">Số lượng:</label>
    <input type="number" id="quantity" name="quantity" required><br>

    <button type="submit">Thêm</button>
    <a href="products">Quay lại</a>
</form>
</body>
</html>
