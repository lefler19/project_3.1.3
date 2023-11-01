//package ru.kata.spring.boot_security.demo.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.entities.Role;
//import ru.kata.spring.boot_security.demo.entities.User;
//import ru.kata.spring.boot_security.demo.services.RoleService;
//import ru.kata.spring.boot_security.demo.services.UserService;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class Init {
//    private final UserService userService;
//
//
//    @Autowired
//    public Init(UserService userService) {
//        this.userService = userService;
//
//    }
//    @PostConstruct
//    public void initializedDataBase() {
//        userService.save(new Role("ROLE_ADMIN"));
//        userService.save(new Role("ROLE_USER"));
//        Set<Role> adminRole = new HashSet<>();
//        Set<Role> userRole = new HashSet<>();
//        Set<Role> allRoles = new HashSet<>();
//        adminRole.add(userService.showUserById(1));
//        userRole.add(userService.showUserById(2));
//        allRoles.add(userService.showUserById(1));
//        allRoles.add(userService.showUserById(2));
//        userService.save(new User("Mike",  "Pyke", adminRole));
//        userService.save(new User("Piter", "Lombok", "lombok@mail.ru","Lombok", userRole));
//        userService.save(new User("Kate", "Java", "java@gmail.com","Java", allRoles));
//    }
//}
