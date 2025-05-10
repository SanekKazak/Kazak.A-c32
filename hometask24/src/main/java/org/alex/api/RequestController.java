package org.alex.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestController {
    public String getTokenFromCookies(HttpServletRequest req){
        var cookies = req.getCookies();

        String token = null;

        for(var cookie : cookies){
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }

        return token;
    }

}
