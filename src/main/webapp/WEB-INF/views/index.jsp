<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Контакты</title>
    <script src="${pageContext.request.contextPath}/resources/js/lib/jquery-1.8.0.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/table_style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/button_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>


<h2>Список телефонов клиентов</h2>
<c:if test="${!empty contactsList}">
    <table class="data">
        <tr>
            <th>ID клиента</th>
            <th>ФИО клиента</th>
            <th>Номер телефона</th>
            <th>Тип контакта</th>
            <th>Комментарий</th>
        </tr>
        <c:forEach items="${contactsList}" var="contact">
            <tr>
                <td name="idClient" class="contact">${contact.idClient}</td>
                <td name="clientFio" class="contact">${contact.clientFio}</td>
                <td name="phoneNumber" class="phone">${contact.phone.phoneNumber}</td>
                <td name="phoneType" class="phone">${contact.phone.phoneType}</td>
                <td name="comment" class="phone">${contact.phone.comment}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button id="btnSaveChanges">Save records</button>
</c:if>
<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/editableTable.js"></script>
</body>
</html>