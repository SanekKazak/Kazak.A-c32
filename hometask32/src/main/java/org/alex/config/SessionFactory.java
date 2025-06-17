package org.alex.config;

import org.alex.entity.OrderEntity;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionFactory {
    private static org.hibernate.SessionFactory session;
    private SessionFactory(){}
    public static org.hibernate.SessionFactory getSession(){
        if(session==null){
            synchronized (SessionFactory.class){
                if(session==null){
                    var properties = getProperties();

                    var configuration = new Configuration();

                    configuration
                            .addAnnotatedClass(OrderEntity.class)
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
