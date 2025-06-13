package org.alex.behaviour_patterns.chain_of_responsibility.chains;

import org.alex.behaviour_patterns.chain_of_responsibility.Request;

public interface Chain {
    void handleChain(Request request);
}
