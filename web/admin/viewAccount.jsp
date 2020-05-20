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
            <tr>
               <td colspan="9"><a href="/accountServlet">Back to Listing</a></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accounts}" var="account">
            <tr>
                <th><input type="text" name="amID" value="${account.getAccountId()}"></th>
                <th><input type="text" name="amName" value="${account.getAccountName()}"></th>
                <th><input type="text" name="amPassword" value="${account.getLoginName()}"></th>
                <th><input type="text" name="amAccess" value="${account.getPassword()}"></th>
                <th><input type="text" name="amAddress" value="${account.getAccountAccess()}"></th>
                <th><input type="text" name="amPhoneNumber" value="${account.getAddress()}"></th>
                <th><input type="text" name="amGender" value="${account.getPhoneNumber()}"></th>
                <th><input type="text" name="amGender" value="${account.isGender()}"></th>
                <th><input type="text" name="amLoginName" value="${account.isStatus()}"></th>
                <td><a href="/accountServlet?action=update&id=${account.getAccountId()}">Update</a></td>
                <td><a href="/accountServlet?action=update&id=${account.getAccountId()})">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
