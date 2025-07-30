<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<a href="auth?lang=ru">RU</a><br>
<a href="auth?lang=en">EN</a><br>

<psp:message code = "auth.head.player"/><br>

<form:form method="post" action="/auth" modelAttribute="playerCredentialsDto">

  <psp:message code = "auth.field.player.login"/><br>
  <form:input path="login"/><br>

  <psp:message code = "auth.field.player.password"/><br>
  <form:input path="password"/><br>

  <input type="submit" <psp:message code = "auth.send.form.button.player"/>><br>
</form:form>

<c:forEach var="error" items="${errors}">
  <li>${error}</li>
</c:forEach>

</body>
</html>