<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 5/22/20
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/reportServlet?action=<%="reportOrdersDetailByTime"%>" method="post">
    <select name="name" id="selectionName">
        <option value="Huynh Bui">Huynh Bui</option>
        <option value="Linh">Linh</option>
        <option value="Huynh">Huynh</option>
        <option value="Thinh">Thinh</option>
    </select>

    <select name="startTime" id="startTime">
        <option value="2020-03-11">2020-03-11</option>
        <option value="2">Feb</option>
        <option value="3">Jan</option>
        <option value="4">Jan</option>
    </select>
    <select name="endTime" id="endTime">
        <option value="2020-03-13">2020-03-13</option>
        <option value="2">Feb</option>
        <option value="3">Jan</option>
        <option value="4">Jan</option>
    </select>
    <input type="submit" value="Get Report">
</form>
</body>
</html>
