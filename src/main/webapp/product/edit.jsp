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
    <title>Edit</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">
    <link href="css/stylehome.css" rel="stylesheet">
    <link href="css/cssviewlistproduct.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body style="background-image: url(/img/background.jpg);">


<header id="header" class="fixed-top ">
    <jsp:include page="generalform/generalform.jsp"></jsp:include>
    <form action="editupdate" method="post" style="background-color: #ede9e9" class="form-horizontal">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT ID</label>
                <div class="col-md-4">
                    <input value="${detail.id}" id="product_name" name="id" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>
                <div class="col-md-4">
                    <input value="${detail.name}" id="product_name" name="name" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT PRICE</label>
                <div class="col-md-4">
                    <input value="${detail.price}" id="product_name" name="price" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT QUANTITY</label>
                <div class="col-md-4">
                    <input value="${detail.quantity}" id="product_name" name="quantity" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT DESCRIPTION</label>
                <div class="col-md-4">
                    <textarea  id="product_name" name="detail" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">${detail.details}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT DATEPOST</label>
                <div class="col-md-4">
                    <input value="${detail.datePost}" id="product_name" name="datepost" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT IMG</label>
                <div class="col-md-4">
                    <input value="${detail.img}" id="product_name" name="img" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT STATUS</label>
                <select name="status" class="form-select" aria-label="Default select example">
                    <option value="COMING_SOON">COMING_SOON</option>
                    <option value="STOCKING">STOCKING</option>
                    <option value="OUT_OF_STOCK">OUT_OF_STOCK</option>
                    <option value="STOP_BUSINESS">STOP_BUSINESS</option>
                </select>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="product_name">PRODUCT DATEPOST</label>
                <div class="col-md-4">
                    <select name="category" class="form-select" aria-label="Default select example">
                        <c:forEach var="o" items="${listCate}">
                            <option value="${o.id}">${o.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <a href="homelogin"><input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"></a>
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Edit</button>
                </div>
            </div>

        </fieldset>
    </form>

<%--    <div id="addEmployeeModal" class="modal fade" align="center" style="background-color: #f3f2ed;width: 300px">--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <form action="editupdate" method="post">--%>
<%--                    <div class="modal-header">--%>
<%--                        <h4 class="modal-title">Edit Product</h4>--%>
<%--                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body">--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Id</label>--%>
<%--                            <input value="${detail.id}" name="id" type="text" class="form-control" readonly required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Name</label>--%>
<%--                            <input value="${detail.name}" name="name" type="text" class="form-control" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Image</label>--%>
<%--                            <input value="${detail.img}" name="img" type="text" class="form-control" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Price</label>--%>
<%--                            <input value="${detail.price}" name="price" type="text" class="form-control" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Quantity</label>--%>
<%--                            <input value="${detail.quantity}" name="quantity" type="text" class="form-control" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Datepost</label>--%>
<%--                            <input value="${detail.datePost}" name="datepost" type="text" class="form-control" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Detail</label>--%>
<%--                            <textarea name="detail" class="form-control" required>${detail.details}</textarea>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Status</label>--%>
<%--                            <select name="status" class="form-select" aria-label="Default select example">--%>
<%--                                <option value="COMING_SOON">COMING_SOON</option>--%>
<%--                                <option value="STOCKING">STOCKING</option>--%>
<%--                                <option value="OUT_OF_STOCK">OUT_OF_STOCK</option>--%>
<%--                                <option value="STOP_BUSINESS">STOP_BUSINESS</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label>Category</label>--%>
<%--                            <select name="category" class="form-select" aria-label="Default select example">--%>
<%--                                <c:forEach var="o" items="${listCate}">--%>
<%--&lt;%&ndash;                                    <option ${idCur==o.id ? "selected" :""} value="${o.id}" >${o.name}</option>&ndash;%&gt;&ndash;%&gt;--%>
<%--                                    <c:if test="${idCur==o.id}">--%>
<%--                                            <option value="${o.id}" selected>${o.name}</option>--%>
<%--                                    </c:if>--%>
<%--                                    <c:if test="${idCur!=o.id}">--%>
<%--                                        <option value="${o.id}" >${o.name}</option>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <a href="homelogin"><input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"></a>--%>
<%--                       <input type="submit" class="btn btn-success" value="Edit">--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <!--Table-->
    <!--Table-->
</header><!-- End Header -->
</body>
</html>
