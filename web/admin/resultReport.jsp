<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 5/22/20
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
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
</head>
<body>
<div class="mainManagement">
    <div class="accountManagement" style="width: 1470px">
        <h6 style="width: 1470px;"><a style="float:right" class="btn btn-outline-primary" href="/accountServlet?action=add">Add more Account</a>&nbsp&nbsp<a class="btn btn-outline-danger" href="admin/admin.jsp">Back to Listing</a></h6>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>OrderID</th>
                <th>OrderDate</th>
                <th>AccountName</th>
                <th>ProductName</th>
                <th>Quantity</th>
                <th>PriceEach</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${results}" var="result">
                <tr>
                    <td><input type="text" name="orderId" value="${result.getOrderId()}"></td>
                    <td><input type="text" name="orderDate" value="${result.getOrderDate()}"></td>
                    <td><input type="text" name="accountName" value="${result.getAccountName()}"></td>
                    <td><input type="text" name="productName" value="${result.getProductName()}"></td>
                    <td><input type="text" name="quantity" value="${result.getQuantity()}"></td>
                    <td><input type="text" name="priceEach" value="${result.getPriceEach()}"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
