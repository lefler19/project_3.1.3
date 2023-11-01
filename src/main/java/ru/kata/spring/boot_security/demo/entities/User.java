package ru.kata.spring.boot_security.demo.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;


import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

//    //Должны загружаться тестовые пользователи(используем @Postconstruct)
//    //(username = admin, password = admin для облегчения тестирования)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=2, message = "Не меньше 5 знаков")
    private String username;
    @Size(min=2, message = "Не меньше 5 знаков")
    private String password;

    //Поле, находящееся под аннотацией Transient, не имеет отображения в БД
    @Transient
    private String passwordConfirm;
//
//    //многие ко многим (один пользователь может иметь несколько ролей с одной стороны и у одной роли может быть несколько пользователей с другой)
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User() {
    }
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
//
//    @Override
//    //@Query("Select u from User u left join fetch u.roles where u.username=:username")

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
