<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<a href="held?lang=ru">RU</a><br>
<a href="held?lang=en">EN</a><br>
<psp:message code = "held.head.match"/><br>

<form:form method="post" action="/held" modelAttribute="matchHeldDto">

  <psp:message code = "held.field.match.match"/><br>
  <form:select path="matchId" multiple="false" items="${matches}" itemValue="id" itemLabel="info"/><br>

  <input type="submit" <psp:message code = "held.send.form.button.match"/>><br>
</form:form>

<c:forEach var="error" items="${errors}">
  <li>${error}</li>
</c:forEach>

</body>
</html>