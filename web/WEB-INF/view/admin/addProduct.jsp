<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 17/05/2020
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ATAG.VN</title>
    <link rel="stylesheet" href="../../../boostrap/css/mainStyle.css">
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
    <link rel="stylesheet" href="../../../boostrap/css/bootstrap.css">
</head>
<body>
<%--HEADER--%>
<header class="header-section">
    <div class="container-fluid">
        <div class="inner-header">
            <div class="logo">
                <a href="../../../index.jsp"><img src="../../../img/logo.png" alt="logo"></a>
            </div>
            <div class="user-access">
                <a class="active" href="../../../index.jsp">Home Page/Logout</a>
                <a href="" class="out"><i class="fa fa-user"></i> Admin</a>
            </div>
        </div>
    </div>
</header>
<hr style="height: 10px">
<div class="mainManagement">
    <div class="productManagement" style="width: 1100px">
        <h3>Product Management</h3>
        <h6><a href="#">Add more Product</a></h6>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Category ID</th>
                <th>Product Price</th>
                <th>Quantity In Stock</th>
                <th>Description</th>
                <th>Image</th>
                <th colspan="2">#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <th><input type="text" name="pmID" value="${product.getProductId()}" style="width: 160px;"></th>
                    <th><input type="text" name="pmName" value="${product.getProductName()}"></th>
                    <th><input type="text" name="pmCategoryID" value="${product.getCategoryName()}"></th>
                    <th><input type="text" name="pmPrice" value="${product.getProductPrice()}"></th>
                    <th><input type="text" name="pmStatus" value="${product.getStatus()}"></th>
                    <th><input type="text" name="pmDes" value="${product.getDescription()}"></th>
                    <th><img src="/img/phone1.png"/></th>
                    <td><a href="#">Update</a></td>
                    <td><a href="#">Delete</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">Total :</td>
                <td>0xxx</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="categoryManagement" style="width: 1100px">
        <h3>Category Management</h3>
        <h6><a href="#">Add more Category</a></h6>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Category Name</th>
                <th colspan="2">#</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><input type="text" name="pmStatus" value="0593XQ"></th>
                <th><input type="text" name="pmDes" value="Samsung"></th>
                <td><a href="#">Update</a></td>
                <td><a href="#">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="accountManagement">
        <h3>Account Management</h3>
        <h6><a href="#">Add more Account</a></h6>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Account Name</th>
                <th>Login Name</th>
                <th>Password</th>
                <th>Account Access</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Gender</th>
                <th scope="col" colspan="2">#</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><input type="text" name="amID" value="example"></th>
                <th><input type="text" name="amName" value="example"></th>
                <th><input type="text" name="amLoginName" value="example"></th>
                <th><input type="text" name="amPassword" value="example"></th>
                <th><input type="text" name="amAccess" value="example"></th>
                <th><input type="text" name="amAddress" value="example"></th>
                <th><input type="text" name="amPhoneNumber" value="example"></th>
                <th><input type="text" name="amGender" value="example"></th>
                <td><a href="#">Update</a></td>
                <td><a href="#">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="orderManagement">
        <h3>Order Management</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Order ID</th>
                <th>Account Name</th>
                <th>Product Name</th>
                <th>Categogy Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th>Order Date</th>
                <th scope="col" colspan="2">#</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><input type="text" name="omID" value="example"></th>
                <th><input type="text" name="omAccName" value="example"></th>
                <th><input type="text" name="omProName" value="example"></th>
                <th><input type="text" name="omCateName" value="example"></th>
                <th><input type="text" name="omPrice" value="example"></th>
                <th><input type="text" name="omQty" value="example"></th>
                <th><input type="text" name="omAmount" value="example"></th>
                <th><input type="text" name="omOrderDate" value="example"></th>
                <td><a href="#">Update</a></td>
                <td><a href="#">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
