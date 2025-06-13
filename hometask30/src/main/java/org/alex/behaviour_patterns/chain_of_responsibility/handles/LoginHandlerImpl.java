package org.alex.behaviour_patterns.chain_of_responsibility.handles;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.alex.behaviour_patterns.chain_of_responsibility.Request;

@NoArgsConstructor
@AllArgsConstructor
public class LoginHandlerImpl implements Handler {
    private Handler nextHandler;
    @Override
    public boolean handle(Request request) {
        if(nextHandler != null && !nextHandler.handle(request)){
            return false;
        }
        if(request.getLogin().isEmpty()){
            System.out.println("login is empty");
            return false;
        }
        return true;
    }
}
