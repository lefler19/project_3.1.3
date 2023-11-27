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

import java.security.Principal;
import java.util.List;

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
    public String showAllUsers(@ModelAttribute ("user") User user, Principal principal, Model model) {
         user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "user_list";
    }
    @PatchMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Integer id) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String updateUserFrom(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        model.addAttribute("roles", roleService.getAllUsers());
        return "redirect:/admin";
    }


    @PatchMapping("/user_update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser (@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }



}
