package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.persistence.VotePersistence;

import java.io.IOException;

@WebServlet(value = "/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var vote_place = req.getParameter("vote_place");
        var ep = new EmployeePersistence();
        var vp = new VotePersistence();
        var token = ep.getTokenFromCookies(req);

    }
}
