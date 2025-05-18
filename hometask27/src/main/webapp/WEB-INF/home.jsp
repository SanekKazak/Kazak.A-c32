<%@ page import="java.util.List" %>
<%@ page import="org.alex.web.Car" %><%--
  Created by IntelliJ IDEA.
  User: kazak
  Date: 17.05.2025
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

    <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        for(Car car : cars){
            out.println(car);
        }
    %>
    <!-- или-->

    <p>${cars}</p>

    <!-- jstl-->

    <c:out value = "${cars}"></c:out>


</body>
</html>
