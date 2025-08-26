package org.spring.hometask50;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class Hometask50Application {

    public static void main(String[] args) {
        SpringApplication.run(Hometask50Application.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(access -> {
                    access
                            .requestMatchers("/user/all", "/user", "/user/register").permitAll()
                            .requestMatchers("/user/auth").authenticated()
                            .requestMatchers("/user/nobody").denyAll()
                            .requestMatchers("/user/read").hasAuthority("read")
                            .requestMatchers("/user/support").hasRole("SUPPORT")
                            .anyRequest().authenticated()
                    ;
                })
                .formLogin( cast ->
                        cast
                                .passwordParameter("password")
                                .usernameParameter("username")
                                .loginPage("/user")
                                .loginProcessingUrl("/user/login")
                )
                .logout( cast ->
                        cast.logoutUrl("/user/logout")
                )
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .build();
    }
}
