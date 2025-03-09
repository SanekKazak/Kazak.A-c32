package org.alex.brain.service;

import org.alex.brain.entity.Authorization;
import org.alex.brain.exception.WrongLoginException;
import org.alex.brain.exception.WrongPasswordException;

public class LoginService {

    public void login(String login, String pass, String confPass){
        boolean correct = true;
        try {
            Authorization.authorization(login, pass, confPass);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            correct = false;
        }
        if(correct){
            System.out.println("All is good");
        }
    }
}
