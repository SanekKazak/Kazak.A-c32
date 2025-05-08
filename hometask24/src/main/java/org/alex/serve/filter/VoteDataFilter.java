package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.entity.Vote;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.persistence.VotePersistence;

import java.io.IOException;

@WebFilter(value = "/vote")
public class VoteDataFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        var vote_place_type = req.getParameter("vote_place");
        var ep = new EmployeePersistence();
        var vp = new VotePersistence();
        var token = ep.getTokenFromCookies(req);

        if(!vote_place_type.isBlank()){
            var login = ep.loginByToken(token);
            var employee = new Employee(login);
            var place = new Place(vote_place_type);
            var vote = new Vote(place, employee);
            var isVoteExist = vp.isVoteExist(vote);
            if(isVoteExist){
                res.setStatus(400);
                req.setAttribute("error", "vote already exist");
                req.getRequestDispatcher("/error").forward(req, res);
                return;
            }
        }

        var place_type = req.getParameter("place_type");
        var not_validated_place_size = req.getParameter("place_size");

        if(place_type.isBlank() || not_validated_place_size.isBlank()){
            chain.doFilter(req, res);
        }

        Integer place_size = null;

        try{
            place_size = Integer.parseInt(not_validated_place_size);
        }catch(NumberFormatException e){
            res.setStatus(400);
            req.setAttribute("error", "size is string");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }



        var loginFromDb = ep.loginByToken(token);
        var employee = new Employee(loginFromDb);
        req.setAttribute("employee", employee);

    }
}
