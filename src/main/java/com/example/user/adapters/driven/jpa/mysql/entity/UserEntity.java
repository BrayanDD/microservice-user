package com.example.user.adapters.driven.jpa.mysql.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails{

    @Id
    @GeneratedValue
    @Column(nullable = false)
    Long id;
    String name;
    String lastName;
    Long docIdent;
    Long cellPhone;
    String email;
    String password;
    

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_Rol")
    private  RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = "ROLE_" + role.getName();
        return List.of(new SimpleGrantedAuthority(roleName));
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
}
