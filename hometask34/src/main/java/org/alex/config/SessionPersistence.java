package org.alex.config;

import org.alex.entity.CarEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionPersistence {
    private static SessionFactory session;
    private SessionPersistence(){}
    public static SessionFactory getSession(){
        if(session==null){
            synchronized (SessionFactory.class){
                if(session==null){
                    var properties = getProperties();

                    var configuration = new Configuration();

                    configuration
                            .addAnnotatedClass(CarEntity.class)
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

        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }
}
