<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<a href="bet?lang=ru">RU</a><br>
<a href="bet?lang=en">EN</a><br>
<psp:message code = "register.head.bet"/><br>

<form:form method="post" action="/register/bet" modelAttribute="betRegistrationDto"><br>

  <psp:message code = "register.field.bet.horse"/><br>
  <form:select path="horseId" multiple="false" items="${horses}" itemValue="id" itemLabel="info"/><br>
  <psp:message code = "register.field.bet.match"/><br>
  <form:select path="matchId" multiple="false" items="${matches}" itemValue="id" itemLabel="info"/><br>
  <psp:message code = "register.field.bet.bet"/><br>
  <form:input path="bet"/>

  <input type="submit" <psp:message code = "register.send.form.button.bet"/>><br>
</form:form>

<c:forEach var="error" items="${errors}">
  <li>${error}</li>
</c:forEach>

</body>
</html>