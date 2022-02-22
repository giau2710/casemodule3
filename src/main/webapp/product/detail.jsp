<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/18/2022
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">
    <link href="css/stylehome.css" rel="stylesheet">
    <link href="css/cssviewlistproduct.css" rel="stylesheet">
    <link href="css/styledetail.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bentham|Playfair+Display|Raleway:400,500|Suranna|Trocchi" rel="stylesheet">
<style>

    .wrapper {
        height: 420px;
        width: 654px;
        margin: 50px auto;
        border-radius: 7px 7px 7px 7px;
        /* VIA CSS MATIC https://goo.gl/cIbnS */
        -webkit-box-shadow: 0px 14px 32px 0px rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0px 14px 32px 0px rgba(0, 0, 0, 0.15);
        box-shadow: 0px 14px 32px 0px rgba(0, 0, 0, 0.15);
    }

    .product-img {
        float: left;
        height: 420px;
        width: 327px;
    }

    .product-img img {
        border-radius: 7px 0 0 7px;
    }

    .product-info {
        float: left;
        height: 420px;
        width: 327px;
        border-radius: 0 7px 10px 7px;
        background-color: #ffffff;
    }

    .product-text {
        height: 300px;
        width: 327px;
    }

    .product-text h1 {
        margin: 0 0 0 38px;
        padding-top: 52px;
        font-size: 34px;
        color: #474747;
    }

    .product-text h1,
    .product-price-btn p {
        font-family: 'Bentham', serif;
    }

    .product-text h2 {
        margin: 0 0 47px 38px;
        font-size: 13px;
        font-family: 'Raleway', sans-serif;
        font-weight: 400;
        text-transform: uppercase;
        color: #d2d2d2;
        letter-spacing: 0.2em;
    }

    .product-text p {
        height: 125px;
        margin: 0 0 0 38px;
        font-family: 'Playfair Display', serif;
        color: #8d8d8d;
        line-height: 1.7em;
        font-size: 15px;
        font-weight: lighter;
        overflow: hidden;
    }

    .product-price-btn {
        height: 103px;
        width: 327px;
        margin-top: 17px;
        position: relative;
    }

    .product-price-btn p {
        display: inline-block;
        position: absolute;
        top: -13px;
        height: 50px;
        font-family: 'Trocchi', serif;
        margin: 0 0 0 38px;
        font-size: 28px;
        font-weight: lighter;
        color: #474747;
    }

    span {
        display: inline-block;
        height: 50px;
        font-family: 'Suranna', serif;
        font-size: 34px;
    }

    .product-price-btn button {
        float: right;
        display: inline-block;
        height: 50px;
        width: 176px;
        margin: 0 40px 0 16px;
        box-sizing: border-box;
        border: transparent;
        border-radius: 60px;
        font-family: 'Raleway', sans-serif;
        font-size: 14px;
        font-weight: 500;
        text-transform: uppercase;
        letter-spacing: 0.2em;
        color: #ffffff;
        background-color: #9cebd5;
        cursor: pointer;
        outline: none;
    }

    .product-price-btn button:hover {
        background-color: #79b0a1;
    }
</style>
</head>
<body style="background-image: url(/img/background.jpg);">


<header id="header" class="fixed-top ">
    <jsp:include page="generalform/generalform.jsp"></jsp:include>


<%--    <div class="card" style="">--%>
<%--        <span class="like"><i class='bx bx-heart'></i></span>--%>
<%--        <span class="cart"><i class='bx bx-cart-alt' ></i></span>--%>
<%--        <div class="card__img">--%>
<%--            <img src="${detail.img}" alt="" />--%>
<%--        </div>--%>
<%--        <h2 class="card__title">${detail.name}</h2>--%>
<%--        <p class="card__price">${detail.price}</p>--%>
<%--        <div class="card__size">--%>
<%--            <span>${detail.details}</span>--%>
<%--        </div>--%>
<%--        <div class="card__color">--%>
<%--            <h3>Color:</h3>--%>
<%--            <span class="green"></span>--%>
<%--            <span class="red"></span>--%>
<%--            <span class="black"></span>--%>
<%--        </div>--%>
<%--        <div class="card__action">--%>
<%--            <button>Buy now</button>--%>
<%--            <button>Add cart</button>--%>
<%--        </div>--%>
<%--    </div>--%>


    <div class="wrapper">
        <div class="product-img">
            <img src="${detail.img}" height="420" width="327">
        </div>
        <div class="product-info">
            <div class="product-text">
                <h1>${detail.name}</h1>
                <h2>${detail.status}</h2>
                <p>${detail.details}</p>
            </div>
            <div class="product-price-btn">
                <p><span>${detail.price}</span>VND</p>
            </div>
            <div class="product-price-btn">
            <a href="homelogin"><button type="button">Can</button></a>
            </div>
        </div>
    </div>

    </body>
</body>
</html>
