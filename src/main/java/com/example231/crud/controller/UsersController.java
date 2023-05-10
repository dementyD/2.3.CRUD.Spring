package com.example231.crud.controller;

import com.example231.crud.model.User;
import com.example231.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String getNew(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        userService.removeUser(id);
        return "redirect:/users";
    }

}



