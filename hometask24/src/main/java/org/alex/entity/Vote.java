package org.alex.entity;


import lombok.Getter;
import org.alex.serve.persistence.VotePersistence;

@Getter
public class Vote extends Entity<Vote> {
    private Place place;
    private Employee employee;

    public Vote(Place place, Employee employee) {
        this.place = place;
        this.employee = employee;
        persistence = new VotePersistence();
    }

    @Override
    public String toString() {
        return "Vote:" + place.getType() + ", " + employee.getLogin();
    }
}
