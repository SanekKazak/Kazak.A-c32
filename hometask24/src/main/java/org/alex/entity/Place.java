package org.alex.entity;

import jakarta.servlet.annotation.WebServlet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class Place {
    private String type;
    private int size;

    public Place(String type) {
        this.type = type;
    }
}
