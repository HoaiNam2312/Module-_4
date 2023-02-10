<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 07/02/2023
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Tờ khai y tế</title>
    <style>
        .header {
            text-align: center;
            align-content: center;
            width: 100%
        }
        .full {
            width: 100%;
        }
        .divide {
            width: 33.33%;
            float: left;
        }
        .half {
            width: 50%;
            float: left;
        }
        .red {
            color: red;
            font-style: italic;
        }
        span {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h3 class="header">TỜ KHAI Y TẾ</h3>
<h4 class="header"> Đây là tài liệu quan trọng, thông tin của Anh/Chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để phòng chống dịch
    bệnh truyền nhiễm</h4>
<h5 class="header" style="color: red">Khuyến cáo khai báo thông tin sai là vi pham pháp luật Việt Nam và có thể bị xử lý hình sự</h5>


<form:form action="/save" method="post" modelAttribute="medicalDeclaration">
    <div class="full">
        <span>Họ tên (ghi chữ IN HOA)</span>
        <span class="red"> (*)</span>
        <form:input path="name" cssClass="full" required="required"></form:input>
    </div>
    <br><br>
    <div class="full">
        <div class="divide">
            <span>Năm sinh</span>
            <span class="red">(*)</span>
            <form:select path="yearOfBirth" cssClass="full">
                <form:options items="${yearOfBirth}"></form:options>
            </form:select>
        </div>

        <div class="divide">
            <span>Giới tính</span>
            <span class="red">(*)</span>
            <form:select path="gender" cssClass="full">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nữ</form:option>
            </form:select>
        </div>

        <div class="divide">
            <span>Quốc gia</span>
            <span class="red">(*)</span>
            <form:select path="nationality" cssClass="full">
                <form:options items="${nationality}"></form:options>
            </form:select>
        </div>
    </div>
    <br><br><br><br>

    <div class="full">
        <span>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</span>
        <span class="red"> (*)</span>
        <form:input path="nationalityId" cssClass="full" required="required"/>
    </div>
    <br><br>
    <div class="full">
        <span>Thông tin đi lại</span>
        <span class="red"> (*)</span> <br>
        <form:radiobuttons path="transportVehicle" items="${transportVehicle}" required="required"></form:radiobuttons>
    </div>
    <br><br>
    <div class="full">
        <div class="half">
            <span>Số hiệu phương tiện</span>
            <form:input path="vehicleId" cssClass="full"></form:input>
        </div>
        <div class="half">
            <span>Số ghế</span>
            <form:input path="seatId" cssClass="full"></form:input>
        </div>
    </div>
    <br><br><br><br>
    <div class="full">
        <div class="half">
            <span>Ngày khời hành</span>
            <span class="red"> (*)</span>
            <form:input path="startDate" type="date" cssClass="full" required="required"></form:input>
        </div>
        <div class="half">
            <span>Ngày kết thúc</span>
            <span class="red"> (*)</span>
            <form:input path="endDate" type="date" cssClass="full" required="required"></form:input>
        </div>
    </div>
    <br><br>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
