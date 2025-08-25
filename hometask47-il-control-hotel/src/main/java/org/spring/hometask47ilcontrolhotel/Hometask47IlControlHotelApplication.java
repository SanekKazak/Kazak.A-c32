package org.spring.hometask47ilcontrolhotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Hometask47IlControlHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hometask47IlControlHotelApplication.class, args);
    }

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
