package org.spring.hometask52.services;

import lombok.RequiredArgsConstructor;
import org.spring.hometask52.dto.UserDto;
import org.spring.hometask52.entity.UserEntity;
import org.spring.hometask52.interfaces.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService {
    private final PasswordEncoder encoder;
    private final TokenService tokenService;
    private final UserService service;

    public String auth(UserDto dto) {
        UserEntity findEntity = service.find(dto.getUsername());
        if (encoder.matches(dto.getPassword(), findEntity.getPassword())) {
            return tokenService.generateToken(findEntity);
        }
        return null;
    }
}
