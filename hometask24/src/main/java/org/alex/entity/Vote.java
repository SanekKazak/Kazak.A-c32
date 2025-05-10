package org.alex.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.alex.serve.persistence.VotePersistence;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Vote extends Entity<Vote> {
    private Place place;
    private Employee employee;

}
