<%@ page import="model.Category" %>
<%@ page import="service.CategoryServiceImp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<%
    CategoryServiceImp categoryDAO = new CategoryServiceImp();
%>
<h1>Create new Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="productManagement.jsp">Back to Product list</a>
</p>
<form style = "margin-top: 40px" enctype='multipart/form-data' method="post" action="${pageContext.request.contextPath}/addProduct">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="productId" id="product_id"></td>
            </tr>
            <tr>
                <td>Category: </td>
                <td><select name="categoryId">
                    <%
                        for (Category category : categoryDAO.getListCategory()) {
                    %>
                    <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                    <% } %>
                </select>
                </td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="productName" id="product_name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" name="productPrice" id="product_price"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="number" name="quantityInStock" id="product_quantity"></td>
            </tr>
            <tr>
                <td>Image: </td>
                <td><input type="text" name="productImage" id="product_image"></td>
            </tr>
            <tr>
                <td>Status: </td>
                <td><input type="number" name="status" id="product_status"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="product_description"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>