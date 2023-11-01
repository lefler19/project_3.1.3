package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
public class AdminController {
    private  UserService userService;

    @Autowired
    public AdminController (UserService userService) {
        this.userService = userService;
    }
//    @GetMapping("/admin")
//    public String pageForAuthenticatedUsers() {
//        return "admin";
//    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }
//Ссылка будет иметь вид http://localhost:8080/admin?userId=24&action=delete при выполнении такого запроса будет удален пользователь с id=24.
    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Integer userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteById(userId);
        }
        return "redirect:/admin";
    }

//    @GetMapping("/admin/gt/{userId}")
//    public String  getUser(@PathVariable("userId") Integer userId, Model model) {
//        model.addAttribute("allUsers", userService.usergtList(userId));
//        return "admin";
//    }
}
