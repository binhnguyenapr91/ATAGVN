<%@ page import="service.ProductServiceImp" %>
<%@ page import="model.Product" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="p" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ATAG.VN</title>
    <link rel="stylesheet" href="boostrap/css/mainStyle.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="boostrap/css/bootstrap.css">

</head>
<body>
<%
    ProductServiceImp productServiceImp = new ProductServiceImp();
    Product product = null;
    try {
        product = productServiceImp.getProduct(request.getParameter("productId"));
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<%--HEADER--%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="header-infor.jsp"></jsp:include>


<%--BODY--%>
<section class="cart-total-page spad">
    <div class="container">
        <form action="/cartUpdateServlet?action=Update" class="checkout-form" method="post">
            <div class="checkout-form-row" style="margin-bottom: 0px">
                <div class="col-lg-12">
                    <h3 style="margin-top: 50px; margin-bottom: 30px;">Your Cart</h3>
                </div>
                <div class="orderedListTable">
                    <b><i style="color:red;">${announcement}</i></b>
                    <table class="table table-hover" style="margin-bottom: 20px">
                        <thead>
                        <tr>
                            <th scope="col">Product ID</th>
                            <th scope="col">Ordered Product</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Amount</th>
                            <th scope="col"><input class="btn btn-outline-success" type="submit" value="Update"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${order.items}" var="item">
                            <tr>
                                <td>${item.product.productId}</td>
                                <td>${item.product.productName}</td>
                                <td><p:formatNumber value="${item.price}"></p:formatNumber>₫</td>
                                <td style="width: 80px; height: 20px;">
                                    <i class="qty mt-5" style="height: 30px;">
                                        <input style="width: 54px;height: 20px;" type="number" class="count"
                                               name="quantity" value="${item.quantity}">
                                    </i>
                                </td>
<<<<<<< HEAD
                                <td>
                                    <p:formatNumber value="${item.product.productPrice * item.quantity}"></p:formatNumber>₫
                                </td>
                                <td><a href="/addToCartServlet?${item.quantity}=<%request.getParameter("qty");%>" class="btn-dark">Update</a></td>
                                <td><a href="#">Delete</a></td>
=======
                                <td><p:formatNumber value="${item.price * item.quantity}"></p:formatNumber>₫</td>
                                <td><a href="/cartUpdateServlet?action=Delete&productId=${item.product.productId}"><input name="act" class="btn btn-outline-danger" type="button"
                                                      value="Delete"></a></td>
>>>>>>> 0db28a9b59aaa84158a177b6fc766b94aeb968b2
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="4">Total :</td>
                            <td>
                                <c:set var="totalOrder" value="${0}"/>
                                <c:forEach var="item" items="${order.items}">
<<<<<<< HEAD
                                    <c:set var="totalOrder" value="${totalOrder + item.product.productPrice* item.quantity}"/>
=======
                                    <c:set var="totalOrder"
                                           value="${totalOrder + item.price* item.quantity}"/>
>>>>>>> 0db28a9b59aaa84158a177b6fc766b94aeb968b2
                                </c:forEach>
                                <p:formatNumber value="${totalOrder}"></p:formatNumber>₫

                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">Delivery Cost (2%) :</td>
                            <td><p:formatNumber value="${totalOrder*2/100}"></p:formatNumber>₫</td>
                        </tr>
                        <tr>
                            <td colspan="4">Final :</td>
                            <td><p:formatNumber value="${totalOrder*102/100}"></p:formatNumber>₫</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <a style="float: right; margin-bottom: 40px" href="/pagination" class="btn btn-outline-info"
                   id="backToMain">Tiếp tục mua hàng</a>
            </div>


            <div class="checkout-form-row">
                <div class="col-lg-12">
                    <h3>Your Information (to Order)</h3>
                </div>
                <div>
                    <form action="#" method="post" class="deliveryInformation">
                        <table style="margin-left: 20px; width: 1060px; margin-bottom: 50px;">
                            <tr>
                                <th style="width: 150px">Your Name*</th>
                                <td style="width: 500px"><input type="text" placeholder="Full Name"
                                                                style="font-size: 15px"></td>
                            </tr>
                            <tr>
                                <th style="width: 150px;">Your Email*</th>
                                <td style="width: 500px"><input type="text" placeholder="example@gmail.com"
                                                                style="font-size: 15px"></td>
                            </tr>
                            <tr>
                                <th style="width: 150px;">Your Phone Number*</th>
                                <td style="width: 500px"><input type="text" style="font-size: 15px"></td>
                            </tr>
                            <tr>
                                <th style="width: 150px;">Your Address*</th>
                                <td style="width: 500px"><input type="text" style="font-size: 15px"></td>
                            </tr>
                            <tr>
                                <th style="width: 150px;">Payment Method</th>
                                <td style="width: 500px"><input type="text" value=" Cash on Delivery" disabled
                                                                style="font-size: 15px"></td>
                            </tr>
                            <tr>
                                <th style="width: 150px;">Delivery Date</th>
                                <td style="width: 500px"><input type="text" value=" 3-5 working days " disabled
                                                                style="font-size: 15px"></td>
                            </tr>
                            <tr>
                                <th colspan="2" style="text-align: right"><input type="submit" value="Order"></th>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </form>
    </div>
</section>

<%--FOOTER--%>
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
