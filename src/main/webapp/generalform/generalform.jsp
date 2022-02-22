<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/20/2022
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container d-flex align-items-center justify-content-between">
    <style>
        input:hover {
            background-color: #9bb4bb;
        }
    </style>
    <h1 class="logo"><a href="index">SHOPRICH</a></h1>
    <nav id="navbar" class="navbar">
        <ul>
            <li><a class="nav-link scrollto " href="index">Home</a></li>
            <li class="dropdown"><a href="viewlistproduct"><span>ViewListProduct</span> <i
                    class="bi bi-chevron-down"></i></a>
                <ul>
                    <c:forEach var="c" items="${listCate}">
                        <li><a href="category?id=${c.id}">${c.name}</a></li>
                    </c:forEach>
                </ul>
            </li>
            <li><a class="nav-link scrollto" href="add">AddProduct</a></li>
            <li><a class="nav-link scrollto " href="edit">EditProduct</a></li>
            <li><a>SearchProduct</a></li>
            <li >
                <div class="box">
                    <form action="search" method="get">
                        <input type="text" name="searchproduct" size="30" placeholder="searchproduct"/>
                        <input type="submit" name="" value="search">
                    </form>
                </div>
            </li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->
</div>