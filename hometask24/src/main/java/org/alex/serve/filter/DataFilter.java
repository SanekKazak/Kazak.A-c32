package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.serve.api.Connect;

import java.io.IOException;

@WebFilter(value = {"/register","/login"})
public class DataFilter extends HttpFilter {

    Connect c;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");
        var login = req.getParameter("login");
        var pass = req.getParameter("password");

        HttpServletResponse response = (HttpServletResponse) res;

        if(login.isBlank() || pass.isBlank()){
            response.setStatus(400);
            req.setAttribute("error", "is blank or empty");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}
