package org.alex.brain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum Role {
    DIRECTOR(25000),
    OFFICE_MANAGER(15000);

    private final Integer payment;
}
