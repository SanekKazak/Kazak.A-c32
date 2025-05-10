package org.alex.entity;

import lombok.Getter;
import org.alex.serve.persistence.PlacePersistence;

@Getter
public class Place extends Entity<Place> {
    private String type;
    private int size;

    public Place(String type, int size) {
        this.size = size;
        this.type = type;
        persistence = new PlacePersistence();
    }

    public Place(String type) {
        this.type = type;
        persistence = new PlacePersistence();
    }

    @Override
    public String toString() {
        return "Place:" + type + ", " + size;
    }
}
