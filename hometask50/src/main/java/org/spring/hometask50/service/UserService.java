package org.spring.hometask50.service;

import lombok.RequiredArgsConstructor;
import org.spring.hometask50.dto.UserDto;
import org.spring.hometask50.entity.UserEntity;
import org.spring.hometask50.mapper.UserMapper;
import org.spring.hometask50.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public List<UserEntity> getAll(){
        return repository.findAll();
    }

    public void create(UserDto dto){
        UserEntity entity = mapper.toEntity(dto);
        String encode = encoder.encode(entity.getPassword());
        entity.setPassword(encode);
        repository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow();
    }
}
