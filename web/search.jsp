<%@ page import="java.text.NumberFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATAG.VN</title>
</head>
<body>

<%
    NumberFormat numberFormat = NumberFormat.getNumberInstance();
%>
<%--HEADER--%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="header-infor.jsp"></jsp:include>

<%--SLIDE BAR--%>
<jsp:include page="slide-bar.jsp"></jsp:include>

<%--BODY--%>
<div class="container">
    <div class="searchContent" style="margin: 100px 0">
        <div class="table">
            <form action="/search" method="post">
            <table>
                <tr>
                    <td style="border-top-color : white" ><input name="searchName" type="text" placeholder=" What are you looking for ?" style="height: 70px; width: 800px; border-radius: 50px;border: 1px solid grey; text-indent: 30px"></td>
                    <td style="border-top-color : white"><input type="submit" value="Search" style="height: 70px; width: 200px;border-radius: 50px"></td>
                </tr>
            </table>
            </form>
        </div>
    </div>


    <div class="categoryName" style="margin-bottom: 20px">
        <h3>SEARCHING RESULT</h3>
    </div>
    <div>
        <h4>00 Sản phẩm</h4>
    </div>
    <div class="productListShow" style="margin: 30px">

        <%--        Vòng lặp ở đây để show lần lượt tất cả sản phẩm sau SEARCH--%>
        <c:forEach items="${requestScope['listProduct']}" var="product">

        <div style="padding-top: 40px; padding-bottom: 60px">
            <table style="margin-bottom: 60px">
                <tr>
                    <td rowspan="3"><img class="card-img-top" src="img/phone1.png" style="height: 100%;width: 100%">
                    </td>
                    <td><h4>${product.getProductName()}</h4></td>
                </tr>
                <tr>
                    <td style="vertical-align: top; color: red">Giá bán : <fmt:formatNumber value="${product.getProductPrice()}"></fmt:formatNumber>₫</td>

                </tr>
                <tr>
                    <td style="line-height:25px; vertical-align: top">
                        ${product.getDescription()}
                    </td>
                </tr>
            </table>
            <br>
            <hr style="width: 800px">
        </div>
        </c:forEach>
    </div>
</div>
<%--FOOTER--%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
