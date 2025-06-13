package org.build_patterns.fabric;

public class Event {
    private Type type;

    public Event(Type type){
        this.type = type;
    }

    public Type react() {
        return type;
    }

    enum Type{
        BAD,
        GOOD
    }
}
