package org.alex.behaviour_patterns.chain_of_responsibility.chains;

import org.alex.behaviour_patterns.chain_of_responsibility.Request;
import org.alex.behaviour_patterns.chain_of_responsibility.handles.LoginHandlerImpl;
import org.alex.behaviour_patterns.chain_of_responsibility.handles.PasswordHandlerImpl;

public class AuthorizationChain implements Chain {
    @Override
    public void handleChain(Request request) {
        var chain = new PasswordHandlerImpl(
                new LoginHandlerImpl());
        if(chain.handle(request)){
            System.out.println("Authorization chain prepared to forwarding request");
        }
    }
}
