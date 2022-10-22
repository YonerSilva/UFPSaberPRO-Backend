package com.ufps.UFPSaberPRO.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails {
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public MainUser(String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static MainUser build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRol_name())).collect(Collectors.toList());
        return new MainUser(user.getUsu_email(), user.getUsu_password(), authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
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
