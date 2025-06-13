package org.alex.behaviour_patterns.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Request {
    private String name;
    private String password;
    private String login;
}
