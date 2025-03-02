package org.alex.brain.abstracts.classes;

import lombok.*;
import org.alex.brain.enums.Role;

@ToString
@AllArgsConstructor
@Setter
@Getter
public abstract class Employee {
    private final String name;
    private final String surname;
    private int workingExperience;
    private Role role;

}
