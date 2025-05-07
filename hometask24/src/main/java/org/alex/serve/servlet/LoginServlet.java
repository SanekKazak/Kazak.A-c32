package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.serve.api.Connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    Connect c;

    public LoginServlet() {
        this.c = new Connect();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(c.isExist(new Employee(login, password))){
            resp.setStatus(400);
            req.setAttribute("error", "not exist");
            req.getRequestDispatcher("/error").forward(req, resp);
            return;
        }

        //TODO валидацию и отправку данных по куки
        try(Connection connection = c.getConnect()){
            connection.setAutoCommit(false);
        }catch(SQLException e){

        }


    }
}
