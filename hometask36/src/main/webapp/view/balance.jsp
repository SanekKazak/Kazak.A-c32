<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<a href="balance?lang=ru">RU</a><br>
<a href="balance?lang=en">EN</a><br>
<psp:message code = "update.balance.head.player"/><br>

<form:form method="post" action="/update/balance" modelAttribute="balanceUpdateDto">
    ${balance}<br>

    <psp:message code = "update.balance.field.player.balance"/><br>
    <form:input path="delta"/><br>

    <input type="submit" <psp:message code = "update.balance.send.form.button"/>><br>
</form:form>

<c:forEach var="error" items="${errors}">
    <li>${error}</li>
</c:forEach>

</body>
</html>