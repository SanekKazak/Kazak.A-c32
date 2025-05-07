package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.serve.api.Connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    Connect c;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        var pass = req.getParameter("password");

        try(Connection connection = c.getConnect()){
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO users (login, password) " +
                            "VALUES (?, ?)");
            st.setString(1, login);
            st.setString(2, pass);
            boolean isExecuted = st.execute();

            if(isExecuted){
                resp.sendRedirect("/vote");
            }else{
                resp.setStatus(400);
                System.out.println("in db problems with adding data");
            }

        }catch(Exception e){
            resp.setStatus(500);
        }
    }
}
