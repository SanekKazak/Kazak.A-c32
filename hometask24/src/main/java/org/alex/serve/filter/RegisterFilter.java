package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.service.PersistenceService;

import java.io.IOException;

@WebFilter(value = "/register")
public class RegisterFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        var ps = new PersistenceService();

        var login = req.getParameter("login");
        var password = req.getParameter("password");

        if(login.isBlank() || password.isBlank()){
            res.setStatus(400);
            req.setAttribute("error", "login or password is blank or empty");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        var isExist = ps.isExist(new Employee(login, password));

        if(isExist && req.getRequestURI().equals("/register")){
            res.setStatus(400);
            req.setAttribute("error", "already exist");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}
