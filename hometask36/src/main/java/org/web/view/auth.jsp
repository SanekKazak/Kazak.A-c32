<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login & Registration</title>
</head>
<body>
<h2>Login</h2>
<form method="post" action="login">
    <label for="loginUsername">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="loginPassword">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <button type="submit">Log In</button>
</form>
<hr>
</body>
</html>