package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.serve.persistence.EmployeePersistence;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        var password = req.getParameter("password");
        var ep = new EmployeePersistence();

        ep.createUser(new Employee(login, password));

        PrintWriter out = resp.getWriter();
        out.println("all is good");

    }
}
