package org.alex.behaviour_patterns.chain_of_responsibility.chains;

import org.alex.behaviour_patterns.chain_of_responsibility.Request;
import org.alex.behaviour_patterns.chain_of_responsibility.handles.LoginHandlerImpl;
import org.alex.behaviour_patterns.chain_of_responsibility.handles.NameHandlerImpl;
import org.alex.behaviour_patterns.chain_of_responsibility.handles.PasswordHandlerImpl;

public class RegistrationChain implements Chain {
    @Override
    public void handleChain(Request request) {
        var chain = new PasswordHandlerImpl(
                new LoginHandlerImpl(
                        new NameHandlerImpl()
                ));
        if (chain.handle(request)) {
            System.out.println("registration chain prepared to forwarding request");
        }
    }
}
