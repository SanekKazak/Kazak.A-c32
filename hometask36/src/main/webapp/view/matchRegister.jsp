<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<a href="match?lang=ru">RU</a><br>
<a href="match?lang=en">EN</a><br>
<psp:message code = "register.head.match"/><br>

<form:form method="post" action="/register/match" modelAttribute="matchRegistrationDto"><br>

  <psp:message code = "register.field.match.horses"/><br>
  <form:select path="horsesId" multiple="true" items="${horses}" itemValue="id" itemLabel="info"/><br>

  <input type="submit" <psp:message code = "register.send.form.button.match"/>><br>
</form:form>

<c:forEach var="error" items="${errors}">
  <li>${error}</li>
</c:forEach>

</body>
</html>