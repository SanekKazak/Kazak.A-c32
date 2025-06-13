package org.build_patterns.fabric;

public class Main {
    public static void main(String[] args) {
        NegativReactionImpl negativReaction = new NegativReactionImpl();
        ReactionService reactionService = new ReactionService();
        reactionService.writeLogAnswer(negativReaction);
    }
}
