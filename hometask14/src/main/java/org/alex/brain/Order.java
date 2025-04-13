package org.alex.brain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Order {
    int id;
    boolean status;
    String name;
}
