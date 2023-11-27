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
//public class Util {
//        private final UserService userService;
//        private final RoleService roleService;
//
//        @Autowired
//        public Util(UserService userService, RoleService roleService) {
//            this.userService = userService;
//            this.roleService = roleService;
//        }
//        @PostConstruct
//        public void initializedDataBase() {
//           // roleService.save(new Role("ROLE_ADMIN"));
//          //  roleService.save(new Role("ROLE_USER"));
//            Set<Role> adminRole = new HashSet<>();
//            Set<Role> userRole = new HashSet<>();
//            Set<Role> allRoles = new HashSet<>();
//            adminRole.add(roleService.showUserById(1));
//            userRole.add(roleService.showUserById(2));
//            allRoles.add(roleService.showUserById(1));
//            allRoles.add(roleService.showUserById(2));
//            userService.save(new User("Zolllllla", "zollllla@gmail.ru", "100", adminRole));
//            userService.save(new User("Fablllio",  "fabllio@gmail.ru","100", userRole));
//            userService.save(new User("Arlllia",  "arilla@gmail.com","100", allRoles));
//        }
//}
