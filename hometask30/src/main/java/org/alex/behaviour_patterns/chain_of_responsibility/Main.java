package org.alex.behaviour_patterns.chain_of_responsibility;

import org.alex.behaviour_patterns.chain_of_responsibility.chainCash.ChainFactory;
import org.alex.behaviour_patterns.chain_of_responsibility.chains.ChainTypes;

public class Main {
    public static void main(String[] args) {
        var chain = ChainFactory.create(ChainTypes.Authorization);
        chain.handleChain(new Request("Alex", "", ""));
    }
}
