package org.alex.brain.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongLoginException extends Exception {
    public WrongLoginException(String str){
        super(str);
    }
}
