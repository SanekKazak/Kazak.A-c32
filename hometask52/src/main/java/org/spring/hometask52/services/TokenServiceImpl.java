package org.spring.hometask52.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.spring.hometask52.entity.UserEntity;
import org.spring.hometask52.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    @Value("${key}")
    private String key;
    private SecretKey secretKey;

    @PostConstruct
    private void init(){
        secretKey = Keys.hmacShaKeyFor(key.getBytes());
    }

    @Override
    public String generateToken(UserEntity entity) {

        var roles = entity.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> authority.contains("ROLE_"))
                .toList();

        var authorities = entity.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> !authority.contains("ROLE_"))
                .toList();


        return Jwts.builder()
                .subject(entity.getUsername())
                .claim("id", entity.getId())
                .claim("authority", authorities)
                .claim("roles", roles)
                .claim("username", entity.getUsername())
                .signWith(secretKey)
                .compact();
    }

    @Override
    public void handle(String rawToken) {
        String token = rawToken.substring(7);

        Claims payload = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        var authority = (List<String>)payload.get("authority");
        var roles = (List<String>)payload.get("roles");
        authority.addAll(roles);
        var authorities = authority.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        var authentication = new UsernamePasswordAuthenticationToken(
                payload.get("username", String.class),
                null,
                authorities
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
