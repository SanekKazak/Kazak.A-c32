package org.rides.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.PlayerEntity;

public class PersistenceService {
    private static SessionFactory factory;
    private PersistenceService(){
    }
    public static SessionFactory getPersistence(){
        if(factory == null){
            synchronized (PersistenceService.class){
                if(factory == null){
                    var properties = PersonalProperty.getProperties();

                    var configuration = new Configuration();

                    configuration
                            .addAnnotatedClass(BetEntity.class)
                            .addAnnotatedClass(HorseEntity.class)
                            .addAnnotatedClass(PlayerEntity.class)
                            .addProperties(properties);

                    return configuration.buildSessionFactory();
                }
            }
        }
        return factory;
    }
}
