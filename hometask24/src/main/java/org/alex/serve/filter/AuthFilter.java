package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.serve.api.EmployeePersistence;

import java.io.IOException;

@WebFilter(value = {"/vote", "/login"})
public class AuthFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        var request = (HttpServletRequest)req;
        var response = (HttpServletResponse)res;
        var cookies = request.getCookies();
        var ep = new EmployeePersistence();
        String token = null;

        for(var cookie : cookies) {
            if(cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }

        if(request.getRequestURI().equals("/login") && token == null) {
            chain.doFilter(req, res);
        }

        if(token.isBlank() || token.isEmpty()) {
            response.setStatus(400);
            req.setAttribute("error", "not authorized");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        if(ep.loginByToken(token)==null){
            response.setStatus(400);
            req.setAttribute("error", "token invalid, authentication terminated");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        if(request.getRequestURI().equals("/login")){
            response.sendRedirect(request.getContextPath()+"/vote");
            return;
        }

        chain.doFilter(req, res);
    }
}
