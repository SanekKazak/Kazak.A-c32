package org.alex.brain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongPasswordException extends Exception {
    public WrongPasswordException(String str){
        super(str);
    }
}
