package com.shiva.Asvmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.Asvmall.service.OtpService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/otp")
public class OtpController {
	@Autowired
	private OtpService service;

    @PostMapping("/register")
    public String register(@RequestParam String mobile) {
        return service.register(mobile);
    }

    @PostMapping("/verify")
    public String verify(@RequestParam String mobile, @RequestParam String otp) {
        return service.verifyOtp(mobile, otp);
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam String mobile,
            @RequestParam String name,
            @RequestParam String address
            ) {
        return service.addUser(mobile, name, address);
    }
	

}
