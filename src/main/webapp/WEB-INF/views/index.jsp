<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Контакты</title>
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
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${contactsList}" var="contact">
            <tr>
                <td>${contact.idClient}</td>
                <td>${contact.clientFio}</td>
                <td>${contact.phone.phoneNumber}</td>
                <td>${contact.phone.phoneType}</td>
                <td>${contact.phone.comment}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>