package org.spring.hometask52.services;

import lombok.RequiredArgsConstructor;
import org.spring.hometask52.entity.UserEntity;
import org.spring.hometask52.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserEntity find(String username){
        return repository.findByUsername(username).get();
    }
}
