package org.alex.accociactions.config;

import org.alex.accociactions.manyToMany.entity.ProviderEntity;
import org.alex.accociactions.manyToMany.entity.TowerEntity;
import org.alex.accociactions.oneToMany.entity.ClothEntity;
import org.alex.accociactions.oneToMany.entity.WardrobeEntity;
import org.alex.accociactions.oneToOne.entity.HomeEntity;
import org.alex.accociactions.oneToOne.entity.PersonEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionPersistence {
    private static org.hibernate.SessionFactory session;
    private SessionPersistence(){}
    public static SessionFactory getSession(){
        if(session==null){
            synchronized (SessionFactory.class){
                if(session==null){
                    var properties = getProperties();

                    var configuration = new Configuration();

                    configuration
                            .addAnnotatedClass(HomeEntity.class)
                            .addAnnotatedClass(PersonEntity.class)
                            .addAnnotatedClass(WardrobeEntity.class)
                            .addAnnotatedClass(ClothEntity.class)
                            .addAnnotatedClass(ProviderEntity.class)
                            .addAnnotatedClass(TowerEntity.class)
                            .addProperties(properties);

                    session = configuration.buildSessionFactory();
                }
            }
        }
        return session;
    }
    private static Properties getProperties(){
        Properties properties = new Properties();

        properties.put("hibernate.connection.url", "jdbc:mariadb://localhost:3306/hibernate");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");

        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }
}
