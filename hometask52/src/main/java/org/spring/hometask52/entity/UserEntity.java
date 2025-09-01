package org.spring.hometask52.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@ToString
public class UserEntity implements UserDetails {
    @Id
    @UuidGenerator
    private UUID id;
    private String username;
    private String password;
    private List<String> authorities = new ArrayList<>();

    public UserEntity() {
        authorities.add("read");
    }

    public UserEntity(String username, String password, List<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    public void setAuthorities(String auth) {
        this.authorities = Arrays.stream(auth.split(",")).toList();
    }

}
