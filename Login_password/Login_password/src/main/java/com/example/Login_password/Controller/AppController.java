package com.example.Login_password.Controller;


import com.example.Login_password.Construct.Users;
import com.example.Login_password.Repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    private final AppRepository appRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public AppController(AppRepository appRepository) {
        this.appRepository = appRepository;
    }


    @GetMapping("/test")
    List<Users> test() {
        return appRepository.findAll();
    }

    @GetMapping
    String welcome() {
        return "Hello world";
    }

    @GetMapping("/timo")
    Boolean timo() {
        boolean isPasswordMatches = passwordEncoder.matches("123", appRepository.getTimoPS());
        return isPasswordMatches;
    }

    @PostMapping("/add")
    public String postResponseController(@RequestBody Users new_user) {
        appRepository.save(new Users(new_user.getUsername(), new BCryptPasswordEncoder().encode(new_user.getPassword())));
        return "Updating database with new user completed";
    }



}
