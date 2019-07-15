package com.alevel.trucking.security.services;

import com.alevel.trucking.model.user.Status;
import com.alevel.trucking.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

    private Long id;

    @Getter
    private String username;

    @Getter
    @JsonIgnore
    private String password;

    private String firstName;

    private String secondName;

    private String lastName;

    private String email;

    private String phone;

    private Status status;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id,
                         String username,
                         String password,
                         String firstName,
                         String secondName,
                         String lastName,
                         String email,
                         String phone,
                         Status status,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.authorities = authorities;
    }

    public static UserPrinciple build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new UserPrinciple(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getSecondName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getStatus(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}