package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {
  void save(User user);
  void deleteById(Integer id);

   User showUserById(Integer id);

   void update(Integer id, User user);

UserDetails loadUserByUsername(String username);
 User findByUsername(String username);
 User findByEmail(String email);
 List<User> getAllUsers();
}
