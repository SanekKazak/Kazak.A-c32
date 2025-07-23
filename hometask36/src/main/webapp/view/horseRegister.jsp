<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<a href="horse?lang=ru">RU</a><br>
<a href="horse?lang=en">EN</a><br>
<psp:message code = "register.head.horse"/><br>

<form:form method="post" action="/register/horse" modelAttribute="horseRegistrationDto">

  <psp:message code = "register.field.horse.name"/><br>
  <form:input path="name"/><br>

  <input type="submit" <psp:message code = "register.send.form.button.horse"/>><br>
</form:form>

<c:forEach var="error" items="${errors}">
  <li>${error}</li>
</c:forEach>

</body>
</html>