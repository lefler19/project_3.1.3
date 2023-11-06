package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UserService;
//import ru.kata.spring.boot_security.demo.entities.User;
//import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;


@Controller
public class MainController {
 UserService userService;
 @Autowired
 public void setUserService(UserService userService) {
     this.userService = userService;
 }

    @GetMapping("/")
        public String homePage() {
            return "home";
        }
@GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "authenticated" ;//+ user.getUsername();
}
    // principal краткая инфа о пользователе
    //не работает
//        @GetMapping("/authenticated")
//    public String pageForAuthenticatedUsers(Principal principal) {
//        return "news" + principal.getName();
       // return "secured part of web service";// + principal.getName();
         //   return  "login";
            //выше не работает
       // }
//    @GetMapping("/authenticated")
//    public String pageForAuthenticatedUsers(Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//        return "news" + user.getUsername();
//    } // работает , если не буду использовать rincipal, то убрать

//    @GetMapping("/read_profile")
//    public String pageForReadProfile() {
//        return "profile_page";
//    }
}
