package org.alex.behaviour_patterns.chain_of_responsibility.handles;

import org.alex.behaviour_patterns.chain_of_responsibility.Request;

public interface Handler {
    boolean handle(Request request);
}
