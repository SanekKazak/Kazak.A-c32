package org.alex.serve.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.api.RequestController;
import org.alex.entity.Employee;
import org.alex.entity.Place;
import org.alex.entity.Vote;
import org.alex.serve.service.AuthService;
import org.alex.serve.service.PersistenceService;

import java.io.IOException;

@WebFilter(value = "/vote")
public class VoteFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        var rc = new RequestController();
        var as = new AuthService();
        var ps = new PersistenceService();

        var vote_place_type = req.getParameter("vote_place");
        var token = rc.getTokenFromCookies(req);

        if(token==null || token.isEmpty()) {
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

        /*
         * проверка на цель запроса, если vote_place_type не пустой и не null:
         * цель запроса - добавление голоса пользователя за маршрут
         * будет передан vote_accepted_add в сервлет
         */
        if(vote_place_type!=null && !vote_place_type.isEmpty()){
            var login = as.loginByToken(token);
            var employee = new Employee(login);
            var place = new Place(vote_place_type);
            var vote = new Vote(place, employee);
            var isVoteExist = ps.isExist(vote);
            if(isVoteExist){
                res.setStatus(400);
                req.setAttribute("error", "vote already exist");
                req.getRequestDispatcher("/error").forward(req, res);
                return;
            }
            req.setAttribute("vote_accepted_add", vote);
        }

        /*
         * проверка на цель запроса, если place_type и place_size не пустые и не null:
         * цель запроса - добавление маршрута
         */
        var place_type = req.getParameter("place_type");
        var not_validated_place_size = req.getParameter("place_size");

        if(place_type==null || place_type.isEmpty() || not_validated_place_size == null || not_validated_place_size.isEmpty()){
            chain.doFilter(req, res);
            return;
        }

        int place_size;

        try{
            place_size = Integer.parseInt(not_validated_place_size);
        }catch(NumberFormatException e){
            res.setStatus(400);
            req.setAttribute("error", "size not a number");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        var place = new Place(place_type, place_size);
        var isExistPlace = ps.isExist(place);

        if(isExistPlace){
            res.setStatus(400);
            req.setAttribute("error", "place already exist");
            req.getRequestDispatcher("/error").forward(req, res);
            return;
        }

        req.setAttribute("place_accepted_add", place);

        chain.doFilter(req, res);

    }
}
