package org.alex.api;

import jakarta.servlet.http.HttpServletRequest;

public class RequestController {
    public String getTokenFromCookies(HttpServletRequest req){
        var cookies = req.getCookies();

        String token = null;

        if(cookies == null){
            return token;
        }

        for(var cookie : cookies){
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }

        return token;
    }

}
