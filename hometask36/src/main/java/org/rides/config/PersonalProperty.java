package org.rides.config;

import java.util.Properties;

public class PersonalProperty {
    public static Properties getProperties(){
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
