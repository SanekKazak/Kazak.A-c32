package org.spring.hometask52;

import org.spring.hometask52.filters.TokenAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class Hometask52Application {

    public static void main(String[] args) {
        SpringApplication.run(Hometask52Application.class, args);
    }

    @Bean
    public SecurityFilterChain chain(HttpSecurity http, TokenAuthFilter filter) throws Exception {
        return http
                .authorizeHttpRequests(cust ->
                    cust
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/login/test1").hasRole("ADMIN")
                            .requestMatchers("/login/test2").hasAuthority("write")
                            .anyRequest().authenticated()
                )
                .addFilterAfter(filter, LogoutFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
