<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Quản lý sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        a {
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 4px;
            transition: 0.3s;
        }
        a[href*="edit"] {
            background-color: #ffc107;
            color: black;
        }
        a[href*="delete"] {
            background-color: #dc3545;
            color: white;
        }
        a[href*="edit"]:hover, a[href*="delete"]:hover {
            opacity: 0.8;
        }
        .add-btn {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            background: #28a745;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            transition: 0.3s;
        }
        .add-btn:hover {
            background: #218838;
        }
    </style>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:choose>
        <c:when test="${not empty products}">
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                    <td>
                        <a href="products?action=edit&id=${p.id}">Sửa</a> |
                        <a href="products?action=delete&id=${p.id}" onclick="return confirm('Xóa sản phẩm này?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="5">Không có sản phẩm nào</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
<a href="add_product.jsp" class="add-btn">Thêm sản phẩm</a>
</body>
</html>
