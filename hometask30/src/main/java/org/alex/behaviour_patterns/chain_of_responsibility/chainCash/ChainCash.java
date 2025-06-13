package org.alex.behaviour_patterns.chain_of_responsibility.chainCash;

import lombok.Getter;
import org.alex.behaviour_patterns.chain_of_responsibility.chains.Chain;
import org.alex.behaviour_patterns.chain_of_responsibility.chains.ChainTypes;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ChainCash {
    private final Map<ChainTypes, Chain> cash = new HashMap();

    public void add(ChainTypes type, Chain chain){
        cash.put(type, chain);
    }

    public Chain contains(ChainTypes type){
        if(cash.containsKey(type)){
            return cash.get(type);
        }
        return null;
    }
}
