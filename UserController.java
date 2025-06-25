package com.book.BookShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.BookShop.model.User;
import com.book.BookShop.repo.UserRepo;
@CrossOrigin(origins = "http://localhost:5173")
@RestController

public class UserController {
	 @Autowired
	    private UserRepo userRepository;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	    @PostMapping("/register")
	    public String registerUser(@RequestBody User user) {
	        System.out.println("Register endpoint hit!");

	        if (userRepository.findByEmail(user.getEmail()) != null) {
	            return "Email already registered!";
	        }

	        // Hash the password
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        userRepository.save(user);
	        userRepository.save(user);
	        return "User registered successfully!";
	    }
	    
	    @PostMapping("/login")
	    public String loginUser(@RequestBody User loginData) {
	        User user = userRepository.findByEmail(loginData.getEmail());

	        if (user == null) {
	            return "Email not registered!";
	        }

	        if (!passwordEncoder.matches(loginData.getPassword(), user.getPassword())) {
	            return "Invalid password!";
	        }

	        return "Login successful!";
	    }

}
