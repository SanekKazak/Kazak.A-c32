package org.alex.web.roles;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        System.out.println("init user");
    }

    /*
    не является тех. заданием
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        boolean hasRole = false;
        for(var c : cookies){
            if("role".equals(c.getName())){
                hasRole=true;
                break;
            }
        }
        if(hasRole){
            writer.println("user has role user and admin, with it's possibilities");
        } else{
            resp.addCookie(new Cookie("role", "USER"));
            writer.println("user has role user and his possibilities");
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy user");
    }

}
