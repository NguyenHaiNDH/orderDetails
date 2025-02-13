<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty product}">
    <c:redirect url="products"/>
</c:if>

<html>
<head>
    <title>Chỉnh Sửa Sản Phẩm</title>
</head>
<body>
<h2>Chỉnh Sửa Sản Phẩm</h2>
<form action="products" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${product.id}">

    <label for="name">Tên sản phẩm:</label>
    <input type="text" id="name" name="name" value="${product.name}" required><br>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" step="0.01" value="${product.price}" required><br>

    <label for="quantity">Số lượng:</label>
    <input type="number" id="quantity" name="quantity" value="${product.quantity}" required><br>

    <button type="submit">Cập Nhật</button>
    <a href="products">Hủy</a>
</form>
</body>
</html>
