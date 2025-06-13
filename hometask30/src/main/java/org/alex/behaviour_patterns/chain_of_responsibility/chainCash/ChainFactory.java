package org.alex.behaviour_patterns.chain_of_responsibility.chainCash;

import org.alex.behaviour_patterns.chain_of_responsibility.chains.AuthorizationChain;
import org.alex.behaviour_patterns.chain_of_responsibility.chains.Chain;
import org.alex.behaviour_patterns.chain_of_responsibility.chains.ChainTypes;
import org.alex.behaviour_patterns.chain_of_responsibility.chains.RegistrationChain;

public class ChainFactory {
    private static final ChainCash cash = new ChainCash();

    public static Chain create(ChainTypes type){
        var chain = cash.contains(type);
        if(chain == null){
            switch (type){
                case Authorization -> chain = new AuthorizationChain();
                case Registration -> chain = new RegistrationChain();
            }
            cash.add(type, chain);
        }
        return chain;
    }
}
