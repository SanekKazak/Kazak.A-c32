package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.service.AuthService;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var as = new AuthService();

        var login = req.getParameter("login");
        var password = req.getParameter("password");
        var employee = new Employee(login, password);

        as.setToken(employee);

        var token = as.getToken(employee);
        var cookie = new Cookie("token", token);

        resp.addCookie(cookie);

        resp.sendRedirect(req.getContextPath()+"/vote");

    }
}
