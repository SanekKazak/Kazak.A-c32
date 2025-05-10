package org.alex.entity;

import jakarta.servlet.annotation.WebServlet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.alex.serve.persistence.Persistence;
import org.alex.serve.persistence.PlacePersistence;
import org.alex.serve.persistence.VotePersistence;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class Place extends Entity<Place> {
    private String type;
    private int size;

    public Place(String type) {
        this.type = type;
    }



}
