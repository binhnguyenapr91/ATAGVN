<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ATAG.VN</title>
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
    <link rel="stylesheet" href="boostrap/css/bootstrap.css">
    <link rel="stylesheet" href="boostrap/css/mainStyle.css">
</head>
<body>


<%--HEADER--%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="header-infor.jsp"></jsp:include>

<%--SLIDE BAR--%>
<jsp:include page="slide-bar.jsp"></jsp:include>

<%--BODY--%>

<div class="container">
    <div class="categoryName" style="margin-bottom: 20px">
        <h3>SAMSUNG</h3>
    </div>
    <div class="cf-left" style="margin-bottom: 20px">
        <form action="#">
            <select class="sort">
                <option value="">Sort by</option>
                <option value="">Price (Lowest first)</option>
                <option value="">Price (Highest first)</option>
            </select>
        </form>
    </div>
    <div class="productListShow" style="margin: 30px">

        <%--        Vòng lặp ở đây để show lần lượt tất cả sản phẩm--%>

        <div style="padding-top: 40px; padding-bottom: 60px">
            <table style="margin-bottom: 60px">
                <tr>
                    <td rowspan="3"><img class="card-img-top" src="img/phone1.png" style="height: 100%;width: 100%">
                    </td>
                    <td><h4>OPPO RENO3 PRO</h4></td>
                </tr>
                <tr>
                    <td style="vertical-align: top; color: red">Giá bán : 12.990.000₫</td>
                </tr>
                <tr>
                    <td style="line-height:25px; vertical-align: top">MÀN HÌNH ĐỤC LỖ KÉP ĐỘC ĐÁO : Sáng tạo và khác
                        biệt <br>
                        CAMERA SELFIE KÉP ĐÊM 44MP + 2MP : Xuất hiện đầu tiên trên thế giới <br>
                        4 CAMERA 64MP ẢNH SIÊU NÉT 108MP <br>
                        SẠC NHANH <br>
                        HIỆU NĂNG CẢI TIẾN MẠNH MẼ <br>
                    </td>
                </tr>
            </table>
            <br>
            <hr style="width: 800px">
        </div>
    </div>
</div>

<%--FOOTER--%>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
