package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private  UserService userService;
    private  RoleService roleService;
    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user_list";
    }

    @GetMapping("/user_create")
    public String createUserForm(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllUsers());
        return "user_create";
    }
    @PostMapping("/user_create")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @GetMapping("/user_update/{id}")
    public String updateUserFrom(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        model.addAttribute("roles", roleService.getAllUsers());
        return "user_update";
    }


    @PatchMapping("/user_update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @DeleteMapping("/user_delete/{id}")
    public String deleteUser (@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }



}
