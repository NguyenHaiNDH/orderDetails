<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Chi tiết đơn hàng</title>
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
            display: inline-block;
            margin-top: 10px;
            text-decoration: none;
            background: #28a745;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            transition: 0.3s;
        }
        a:hover {
            background: #218838;
        }
    </style>
</head>
<body>
<h2>Chi tiết đơn hàng</h2>
<table>
    <tr>
        <th>Tên khách hàng</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Giá</th>
    </tr>
    <c:forEach var="od" items="${orderDetailsList}">
        <tr>
            <td>${od.customerName}</td>
            <td>${od.productName}</td>
            <td>${od.quantity}</td>
            <td>${od.price}</td>
        </tr>
    </c:forEach>
</table>
<a href="/LoginWeb_v2_war_exploded/products">Quay lại trang sản phẩm</a>
</body>
</html>
