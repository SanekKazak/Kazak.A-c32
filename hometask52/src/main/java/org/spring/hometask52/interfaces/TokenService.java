package org.spring.hometask52.interfaces;

import org.spring.hometask52.entity.UserEntity;

public interface TokenService {
    String generateToken(UserEntity entity);
    void handle(String token);
}
