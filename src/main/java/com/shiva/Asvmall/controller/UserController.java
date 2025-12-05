package com.shiva.Asvmall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@PostMapping("/addUser")
    public String addUser(@RequestParam String mobile,
                          @RequestParam String name,
                          @RequestParam String address) {
        // Save to DB
        return "User saved successfully";
    }

}
