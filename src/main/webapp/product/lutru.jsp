<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/18/2022
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Img</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>datePost</th>
            <th>Status</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${listP}">
            <tr>
                <th>${p.id}</th>
                <th>${p.img}</th>
                <th>${p.name}</th>
                <th>${p.price}</th>
                <th>${p.quantity}</th>
                <th>${p.datePost}</th>
                <th>${p.status}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
