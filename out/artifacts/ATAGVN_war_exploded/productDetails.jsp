<%@ page import="service.ProductServiceImp" %>
<%@ page import="model.Product" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ATAG.VN</title>
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
    <link rel="stylesheet" href="boostrap/css/mainStyle.css">
</head>
<body>
<%
    ProductServiceImp productServiceImp = new ProductServiceImp();
    Product product = productServiceImp.getProduct(request.getParameter("productId"));
    NumberFormat format = NumberFormat.getNumberInstance();
%>
<%--HEADER--%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="header-infor.jsp"></jsp:include>

<section class="product-page"   style="padding-bottom: 100px;padding-top: 100px">
    <div class="container-fluid">
        <br>
        <div class="row">
            <div class="col-lg-6 text-left">
                <img src="<%=product.getImage()%>" width="620" height="350"/>
            </div>
            <div class="col-lg-6">
                <div class="product-content">
                    <h2><%=product.getProductName()%></h2>
                    <div class="price">
                        <h5 style="color:red; padding-bottom: 15px"><%=format.format(product.getProductPrice())%>₫</h5>
                    </div>
                    <p class="description">
                        <%=product.getDescription()%>
                    </p>
                    <table class="tags">
                        <tr>
                            <td>Tồn Kho :</td>
                            <td><input style="background-color: transparent; border-color: transparent" type="text" name="quantityInStock" disabled value="<%=product.getQuantityInStock()%>"></td>
                        </tr>
                    </table>
                    <div class="product-quantity">
                        <div class="pro-qty">
                            <input type="text" value="1" name="productQuantity">
                        </div>
                    </div>
                    <a href="#" class="primary-btn pc-btn" id="addToCart"><i class="fa fa-cart-plus"></i></a>
                    <a href="#" class="primary-btn pc-btn" id="backToMain">Tiếp tục mua hàng</a>
                </div>
            </div>
        </div>
    </div>
</section>

<br>
<%--FOOTER--%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
