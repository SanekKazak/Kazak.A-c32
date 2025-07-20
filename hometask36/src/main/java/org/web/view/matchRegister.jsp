<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration match</title>
</head>
<body>
<h2>Register</h2>
<form method="post" action="register">
    <label for="registerUsername">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="registerPassword">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <button type="submit">Register</button>
</form>
</body>
</html>