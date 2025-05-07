package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.serve.api.Connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    Connect c;

    public RegisterServlet() {
        this.c = new Connect();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        var password = req.getParameter("password");

        if(c.isExist(new Employee(login, password))){
            resp.setStatus(400);
            req.setAttribute("error", "already exist");
            req.getRequestDispatcher("/error").forward(req, resp);
            return;
        }

        try(Connection connection = c.getConnect()){
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO users (login, password) VALUES (?, ?)");
            st.setString(1, login);
            st.setString(2, password);

            st.execute();

            PrintWriter out = resp.getWriter();
            out.println("all is good");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
