package org.alex;

import java.sql.SQLException;
import java.util.Random;

public class Service {
    private final long session;
    public String url;
    public String user;
    public String pass;

    public Service(String url, String user, String pass){
        this.pass = pass;
        this.url = url;
        this.user = user;
        Random random = new Random();
        session = random.nextLong(10_000) * random.nextLong(10_000);
    }

    public String write(String str){
        try(Jdbc jdbc = new Jdbc()){
            jdbc.connectionSet(url, user, pass);
            return jdbc.write(str, String.valueOf(session));
        }catch(SQLException e){
            return e.getMessage();
        }
    }

    public String readAll(){
        try(Jdbc jdbc = new Jdbc()){
            jdbc.connectionSet(url, user, pass);
            return jdbc.readAll();
        }catch(SQLException e){
            return e.getMessage();
        }
    }
}
