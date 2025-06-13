package org.build_patterns.fabric;

public class NegativReactionImpl implements Reaction{
    @Override
    public Event generate() {
        return new Event(Event.Type.BAD);
    }
}
