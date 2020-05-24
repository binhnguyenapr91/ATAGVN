<%--
  Created by IntelliJ IDEA.
  User: HoangLinh
  Date: 5/17/2020
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="boostrap/css/bootstrap.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="boostrap/css/mainStyle.css">
</head>
<body class="bodyImage" style='background-image: url("/img/backGroundLogin.png"); '>

<%--HEADER--%>
<div class="containerLogin">
    <div class="loginPanel">
        <form action="/login?action=login" method="post">
            <table>
                <tr>
                    <td colspan="2" style="text-align: center"><b>LOGIN !</b></td>
                </tr>
                <tr>
                    <td style="width: 100px;">Username : </td>
                    <td><input type="text" name="username" style="border-radius: 2px"></td>
                </tr>
                <tr>
                    <td>Password : </td>
                    <td><input type="password" name="password" style="border-radius: 2px"></td>
                </tr>
                <tr>
                    <td><a href="/signUp.jsp"><input type="button" value="SignUp"></a></td>
                    <td><input type="submit" value="Login">&nbsp<a href=""> Forgot Password ?</a></td>
                </tr>
            </table>
        </form>
        <i style="color: red">${announcement}</i>
    </div>
</div>
</body>
</html>
