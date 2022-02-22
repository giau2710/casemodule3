<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/21/2022
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">
    <link href="css/stylehome.css" rel="stylesheet">
    <link href="css/cssviewlistproduct.css" rel="stylesheet">
</head>
<body style="background-image: url(/img/background.jpg);">
<header id="header" class="fixed-top ">
<div class="container d-flex align-items-center justify-content-between">
    <style>
        input:hover {
            background-color: #9bb4bb;
        }
    </style>
    <h1 class="logo"><a href="customer">SHOPRICH</a></h1>
    <nav id="navbar" class="navbar">
        <ul>
            <li><a class="nav-link scrollto " href="customer">Home</a></li>
            <li class="dropdown"><a href="viewlistproductc"><span>ViewListProduct</span> <i
                    class="bi bi-chevron-down"></i></a>
                <ul>
                    <c:forEach var="c" items="${listCate}">
                        <li><a href="categoryc?id=${c.id}">${c.name}</a></li>
                    </c:forEach>
                </ul>
            </li>
            <li><a class="nav-link scrollto" href="addCart">AddCart</a></li>
            <li><a>SearchProduct</a></li>
            <li >
                <div class="box">
                    <form action="search" method="get">
                        <input type="text" name="searchproductc" size="30" placeholder="searchproduct"/>
                        <input type="submit" name="" value="search">
                    </form>
                </div>
            </li>
            <li><a class="nav-link scrollto" href="customer?action=loginc">Login</a></li>
            <li><a class="nav-link scrollto" href="customer?action=signup">Sign Up</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->
</div>
</header>
</body>
</html>
