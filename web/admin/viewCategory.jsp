<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 5/21/20
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin - Categories Managerment</title>
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
<%--HEADER--%>
<header class="header-section">
    <div class="container-fluid">
        <div class="inner-header">
            <div class="logo">
                <a href="index.jsp"><img src="img/logo.png" alt="logo"></a>
            </div>
            <div class="user-access">
                <a class="active" href="index.jsp">Home Page/Logout</a>
                <a href="" class="out"><i class="fa fa-user"></i> Admin</a>
            </div>
        </div>
    </div>
</header>
<hr style="height: 10px">
<div class="mainManagement">
        <h3>Category Management</h3>
        <h6><a href="/categoryServlet?action=add">Add more Category</a>|<a href="/categoryServlet">Back to Listing</a></h6>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Category ID</th>
                <th>Category Name</th>
                <th scope="col" colspan="2">Functions</th>
            </tr>

            </thead>
            <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <th><input type="text" name="categoryId" value="${category.getCategoryId()}"></th>
                    <th><input type="text" name="categoryName" value="${category.getCategoryName()}"></th>
                    <td><a href="/categoryServlet?action=update&categoryId=${category.getCategoryId()}">Update</a></td>
                    <td><a href="/categoryServlet?action=delete&categoryId=${category.getCategoryId()}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>

