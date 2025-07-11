package org.rides.utils;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rides.config.PersonalProperty;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.entity.PlayerEntity;
import org.springframework.stereotype.Service;

@Service
@Getter
public class PersistenceService {
    private final SessionFactory factory;

    public PersistenceService(){
        var configuration = new Configuration();
        var properties = PersonalProperty.getProperties();

        configuration
                .addAnnotatedClass(BetEntity.class)
                .addAnnotatedClass(HorseEntity.class)
                .addAnnotatedClass(PlayerEntity.class)
                .addAnnotatedClass(MatchEntity.class)
                .addProperties(properties);

        factory = configuration.buildSessionFactory();
    }
}
