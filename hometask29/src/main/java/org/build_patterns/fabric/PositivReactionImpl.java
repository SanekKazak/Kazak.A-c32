package org.build_patterns.fabric;

public class PositivReactionImpl implements Reaction{
    @Override
    public Event generate() {
        return new Event(Event.Type.GOOD);
    }
}
