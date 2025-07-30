<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="psp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>
<a href="auth?lang=ru">RU</a>
<a href="auth?lang=en">EN</a>
<psp:message code = "error.page.data"/>
${error}
</body>
</html>