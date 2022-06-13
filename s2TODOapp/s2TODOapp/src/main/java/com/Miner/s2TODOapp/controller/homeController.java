package com.Miner.s2TODOapp.controller;

import com.Miner.s2TODOapp.model.User;
import com.Miner.s2TODOapp.repository.ToDoReposirtory;
import com.Miner.s2TODOapp.repository.UserRepository;
import com.Miner.s2TODOapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homeController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ToDoService toDoService;
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("allTodo",toDoService.getAllTodo());
        return "welcome";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}