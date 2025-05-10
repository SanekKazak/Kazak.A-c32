package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.api.RequestController;
import org.alex.entity.Employee;
import org.alex.serve.service.PersistenceService;

import java.io.IOException;

@WebFilter(value = "/login")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        var ps = new PersistenceService();
        var rc = new RequestController();

        var login = req.getParameter("login");
        var password = req.getParameter("password");
        var employee = new Employee(login, password);

        if(login==null || login.isEmpty() || password==null || password.isEmpty()){
            res.setStatus(400);
            req.setAttribute("error", "login or password is blank or empty");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        var token = rc.getTokenFromCookies(req);

        if(token!=null && !token.isEmpty()){
            res.sendRedirect(req.getContextPath()+"/vote");
            return;
        }

        var isExist = ps.isExist(employee);

        if(!isExist && req.getRequestURI().equals("/login")){
            res.setStatus(400);
            req.setAttribute("error", "not exist");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}
