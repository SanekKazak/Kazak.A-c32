package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.api.RequestController;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.service.AuthService;

import java.io.IOException;

@WebFilter(value = "/vote")
public class VoteAuthFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        var rc = new RequestController();
        var as = new AuthService();
        var token = rc.getTokenFromCookies(req);

        if(token.isBlank() || token.isEmpty()) {
            res.setStatus(400);
            req.setAttribute("error", "not authorized");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        if(as.loginByToken(token)==null){
            var cookie = new Cookie("token", "");
            res.addCookie(cookie);
            res.setStatus(400);
            req.setAttribute("error", "token invalid, authentication terminated");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}
