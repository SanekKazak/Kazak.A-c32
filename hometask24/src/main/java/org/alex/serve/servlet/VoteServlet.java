package org.alex.serve.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.entity.Vote;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.persistence.PlacePersistence;
import org.alex.serve.persistence.VotePersistence;
import org.alex.serve.service.PersistenceService;

import java.io.IOException;

@WebServlet(value = "/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var ps = new PersistenceService();

        var place = (Place) req.getAttribute("place_accepted_add");
        var vote = (Vote) req.getAttribute("vote_accepted_add");

        if(place!=null){
            ps.create(place);
        }

        if(vote!=null){
            ps.create(vote);
        }

    }
}
