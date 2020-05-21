<%@ page import="service.ProductServiceImp" %>
<%@ page import="service.CategoryServiceImp" %>
<%@ page import="model.Product" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ATAG.VN</title>
    <link rel="stylesheet" href="../boostrap/css/mainStyle.css">
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
    <link rel="stylesheet" href="../boostrap/css/bootstrap.css">
    <link rel="stylesheet" href="../boostrap/css/mainStyle.css">
</head>
<body>
<%
    ProductServiceImp productDAO = new ProductServiceImp();
    CategoryServiceImp categoryDAO = new CategoryServiceImp();
    NumberFormat format = NumberFormat.getNumberInstance();
%>
<%--HEADER--%>
<header class="header-section">
    <div class="container-fluid">
        <div class="inner-header">
            <div class="logo">
                <h2 style="margin-bottom: 20px">PRODUCT <small class="text-muted">Management</small></h2>
            </div>
            <div class="user-access">
                <a style="margin: 30px" class="active" href="/pagination">Home Page/Logout</a>
                <a href="" class="out"><i class="fa fa-user"></i>&nbspAdmin</a>
            </div>
        </div>
    </div>
</header>
<hr style="height: 10px">
<div class="mainManagement">
    <div class="productManagement" style="width: 1470px">

        <h6 class="btn btn-outline-primary" style="float: right;margin: 10px 10px"><a href="/admin/createProduct.jsp">Add more Product</a></h6>
        <table class="table table-hover">
            <thead>
            <tr>
                <th style="width: 80px;">ID</th>
                <th style="width: 100px;">Category ID</th>
                <th style="width: 150px;">Product Name</th>
                <th style="width: 150px;">Product Price</th>
                <th style="width: 160px;">Quantity In Stock</th>
                <th style="width: 100px;">Image</th>
                <th style="width: 80px;">Status</th>
                <th style="width: 300px;">Description</th>
                <th style="width: 70px;" colspan="2">#</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Product product: productDAO.getListProduct()){
            %>
                <tr>
                    <th style="width: 80px;"><input  style="width: 80px;" type="text" name="pmID" value="<%=product.getProductId()%>"></th>
                    <th style="width: 100px;"><input style="width: 100px;" type="text" name="pmCategoryID" value="<%=categoryDAO.getCategory(product.getCategoryId()).getCategoryName()%>"></th>
                    <th style="width: 150px;"><input style="width: 150px;" type="text" name="pmName" value="<%=product.getProductName()%>"></th>
                    <th style="width: 150px;"><input style="width: 150px;"type="text" name="pmPrice" value="<%=format.format(product.getProductPrice())%>"></th>
                    <th style="width: 160px;"><input style="width: 160px;"type="text" name="pmQuantity" value="<%=product.getQuantityInStock()%>"></th>
                    <th style="width: 100px;"><img style="width: 100px;"src="../<%=product.getImage()%>"/></th>
                    <th style="width: 80px;"><input style="width: 80px;"type="text" name="pmStatus" value="<%=product.getStatus()%>"></th>
                    <th style="width: 300px;"><textarea cols="35" rows="6" name="pmDes" value="<%=product.getDescription()%>" ></textarea></th>
                    <th style="width: 70px;"><a class="btn btn-outline-success" href="/admin/updateProduct.jsp?productId=<%=product.getProductId()%>">Update</a></th>
                    <th style="width: 70px;"><a class="btn btn-outline-danger" href="/deleteProduct?productId=<%=product.getProductId()%>">Delete</a></th>
                </tr>
            <%
                }
            %>
            <tr>
                <td style="color: blue" colspan="4"><b>Total :</b></td>
                <td style="color: blue"><b>
                    <%
                        int count = 0;
                        List<Product> list = productDAO.getListProduct();
                        for (Product product : list) {
                            count += product.getQuantityInStock();
                        }

                    %>
                    <%=count%></b>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

<%--    <div class="categoryManagement" style="width: 1100px">--%>
<%--        <h3>Category Management</h3>--%>
<%--        <h6><a href="#">Add more Category</a></h6>--%>
<%--        <table class="table table-hover">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>ID</th>--%>
<%--                <th>Category Name</th>--%>
<%--                <th colspan="2">#</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <th><input type="text" name="pmStatus" value="0593XQ"></th>--%>
<%--                <th><input type="text" name="pmDes" value="Samsung"></th>--%>
<%--                <td><a href="#">Update</a></td>--%>
<%--                <td><a href="#">Delete</a></td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--    <div class="accountManagement">--%>
<%--        <h3>Account Management</h3>--%>
<%--        <h6><a href="#">Add more Account</a></h6>--%>
<%--        <table class="table table-hover">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>ID</th>--%>
<%--                <th>Account Name</th>--%>
<%--                <th>Login Name</th>--%>
<%--                <th>Password</th>--%>
<%--                <th>Account Access</th>--%>
<%--                <th>Address</th>--%>
<%--                <th>Phone Number</th>--%>
<%--                <th>Gender</th>--%>
<%--                <th scope="col" colspan="2">#</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <th><input type="text" name="amID" value="example"></th>--%>
<%--                <th><input type="text" name="amName" value="example"></th>--%>
<%--                <th><input type="text" name="amLoginName" value="example"></th>--%>
<%--                <th><input type="text" name="amPassword" value="example"></th>--%>
<%--                <th><input type="text" name="amAccess" value="example"></th>--%>
<%--                <th><input type="text" name="amAddress" value="example"></th>--%>
<%--                <th><input type="text" name="amPhoneNumber" value="example"></th>--%>
<%--                <th><input type="text" name="amGender" value="example"></th>--%>
<%--                <td><a href="#">Update</a></td>--%>
<%--                <td><a href="#">Delete</a></td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--    <div class="orderManagement">--%>
<%--        <h3>Order Management</h3>--%>
<%--        <table class="table table-hover">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>Order ID</th>--%>
<%--                <th>Account Name</th>--%>
<%--                <th>Product Name</th>--%>
<%--                <th>Categogy Name</th>--%>
<%--                <th>Price</th>--%>
<%--                <th>Quantity</th>--%>
<%--                <th>Amount</th>--%>
<%--                <th>Order Date</th>--%>
<%--                <th scope="col" colspan="2">#</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <th><input type="text" name="omID" value="example"></th>--%>
<%--                <th><input type="text" name="omAccName" value="example"></th>--%>
<%--                <th><input type="text" name="omProName" value="example"></th>--%>
<%--                <th><input type="text" name="omCateName" value="example"></th>--%>
<%--                <th><input type="text" name="omPrice" value="example"></th>--%>
<%--                <th><input type="text" name="omQty" value="example"></th>--%>
<%--                <th><input type="text" name="omAmount" value="example"></th>--%>
<%--                <th><input type="text" name="omOrderDate" value="example"></th>--%>
<%--                <td><a href="#">Update</a></td>--%>
<%--                <td><a href="#">Delete</a></td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>
</div>
</body>
</html>
