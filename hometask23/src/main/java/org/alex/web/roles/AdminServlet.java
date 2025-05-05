package org.alex.web.roles;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config){
        System.out.println("init admin");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie roleCookie = new Cookie("role", "ADMIN");
        resp.addCookie(roleCookie);
        resp.sendRedirect("http://127.0.0.1:8080/hometask23/user");
    }

    @Override
    public void destroy() {
        System.out.println("destroy admin");
    }
}
