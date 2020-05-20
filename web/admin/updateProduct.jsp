<%@ page import="model.Category" %>
<%@ page import="model.Product" %>
<%@ page import="service.ProductServiceImp" %>
<%@ page import="service.CategoryServiceImp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<%
    ProductServiceImp productDAO = new ProductServiceImp();
    CategoryServiceImp categoryDAO = new CategoryServiceImp();
    Product product = productDAO.getProduct(request.getParameter("productId"));
%>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="productManagement.jsp">Back to product list</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/updateProduct">
    <fieldset>
        <legend>Customer information</legend>
        <table>
<%--            <c:if test="${product != null}">--%>
<%--                <input type="hidden" name="productId" value="<c:out value='<%=product.getProductId()%>' />"/>--%>
<%--            </c:if>--%>
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
                <td><input type="number" name="status" id="status"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="product_description"></td>
            </tr>
            <tr>
                <td></td>
                <input type="hidden" name="productId" value="<c:out value='<%=product.getProductId()%>' />"/>
                <td><input type="submit" value="Edit product"></td>

            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>