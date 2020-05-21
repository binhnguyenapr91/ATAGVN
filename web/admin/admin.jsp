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
<header class="header-section" style="margin-bottom: 30px;height: 130px; background-image: url('https://avante.biz/wp-content/uploads/Macbook-Pro-15-Inch-Retina-Wallpapers/Macbook-Pro-15-Inch-Retina-Wallpapers-012.jpg')">
    <div class="container-fluid">
        <div class="inner-header">

            <div class="user-access" style="vertical-align: middle">
                <a style="font-size: 20px;color:white;" class="active" href="index.jsp">Home Page/Logout</a>
                <a style="font-size: 20px;color:white;" href="" class="out"><i class="fa fa-user"></i> Admin</a>
            </div>
        </div>
    </div>
</header>
<div class="container-fluid">
    <h3>Admin Management Page</h3>
    <form action="">
        <table>
            <tr>
                <td><input style="background-color: #c69500" type="submit" value="Product Management"></td>
                <td><input style="background-color: #8fd19e" type="submit" value="Category Management"></td>
                <td><input style="background-color: #ed969e" type="submit" value="Account Management"></td>
                <td><input style="background-color: #0056b3" type="submit" value="Order Management"></td>
            </tr>
        </table>
    </form>
</div>
<style>
    .container-fluid table tr td input{
        width: 250px;
        height: 100px;
        border-radius: 10px;
        border: 1px black solid;
        margin: 50px;
        font-weight: bold;
    }
</style>
</body>
</html>
