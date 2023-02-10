<%--
  Created by IntelliJ IDEA.
  User: namho
  Date: 08/02/2023
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b>Họ tên:</b>
<span>${medicalDeclaration.name}</span><br>
<b>Năm sinh:</b>
<span>${medicalDeclaration.yearOfBirth}</span><br>
<b>Giới tính:</b>
<span>${medicalDeclaration.gender}</span><br>
<b>Quốc tịch:</b>
<span>${medicalDeclaration.nationality}</span><br>
<b>Số CMND:</b>
<span>${medicalDeclaration.nationalityId}</span><br>
<b>Phương tiện đi lại:</b>
<span>${medicalDeclaration.transportVehicle}</span><br>
<b>Số hiệu phương tiện:</b>
<span>${medicalDeclaration.vehicleId}</span><br>
<b>Số ghế:</b>
<span>${medicalDeclaration.seatId}</span><br>
<b>Ngày khởi hành:</b>
<span>${medicalDeclaration.startDate}</span><br>
<b>Ngày kết thúc:</b>
<span>${medicalDeclaration.endDate}</span><br>
</body>
</html>
