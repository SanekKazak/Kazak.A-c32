package org.build_patterns.fabric;

public class ReactionService {
    public void writeLogAnswer(Reaction reaction){
        Event event = reaction.generate();
        System.out.println("Actual reaction is " + event.react());
    }
}
