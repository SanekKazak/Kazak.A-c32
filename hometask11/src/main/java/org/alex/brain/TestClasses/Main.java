package org.alex.brain.TestClasses;

import org.alex.brain.service.LoginService;

public class Main {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        loginService.login("Alex11", "1231", "1231");
        loginService.login("Alex11 ", "1231", "1231");
        loginService.login("Alexxxxxxxxxxxxxxxxxxxxxx", "1231", "1231");
        loginService.login("Alex11", "1231 ", "1231");
        loginService.login("Alex11", "1231", "12311");
        loginService.login("Alex11", "123122222222222222222222", "123122222222222222222222");
        loginService.login("Alex11", "asda", "asda");
    }
}
