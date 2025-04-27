package org.alex.brain.entity;


import org.alex.brain.exception.WrongLoginException;
import org.alex.brain.exception.WrongPasswordException;

public class Authorization {
    public static void authorization(String login, String pass, String confPass) throws WrongLoginException, WrongPasswordException {
        if(login.length()>20){
            throw new WrongLoginException("Login is to large, more 20");
        }
        if(login.contains(" ")){
            throw new WrongLoginException("Login should not contain spaces");
        }
        if(pass.length()>20){
            throw new WrongPasswordException("Password is to large, more 20");
        }
        if(pass.contains(" ")){
            throw new WrongPasswordException("Password should not contain spaces");
        }
        if (!pass.matches(".*\\d.*")) {
            throw new WrongPasswordException("Password must contain at least one digit");
        }
        if(!pass.equals(confPass)){
            throw new WrongPasswordException("Password not matches with confirm password");
        }
    }
}
