package com.esl.candidato.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.esl.candidato.domain.Enums.RoleType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails{
  private static final long serialVersionUID = 1L;

      private Integer id;
      private String email;
      private String senha;
      private Collection<? extends GrantedAuthority> authorities;

     
     public UserSS(){

     }
      public UserSS(Integer id, String email, String senha, Set<RoleType> roles) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.authorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());
    }


    public Integer getId(){
          return id;
      }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
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


    public boolean hasRole(RoleType roleType) {
        return getAuthorities().contains(new SimpleGrantedAuthority(roleType.getDescription()));
    }
    
}