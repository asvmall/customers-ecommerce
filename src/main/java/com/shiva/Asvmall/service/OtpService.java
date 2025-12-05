package com.shiva.Asvmall.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.Asvmall.entity.OtpVerificationEntity;
import com.shiva.Asvmall.entity.UserEntity;
import com.shiva.Asvmall.repository.OtpRepository;
import com.shiva.Asvmall.repository.UserRepository;

@Service
public class OtpService {

    @Autowired
    private OtpRepository repo;

    @Autowired
    private UserRepository userRepo;

    // 1. Registration - Generate OTP
    public String register(String mobile) {

        // Generate 4-digit OTP
        int otp = (int) (Math.random() * 9000) + 1000;

        OtpVerificationEntity o = new OtpVerificationEntity();
        o.setMobile(mobile);
        o.setOtp_code(String.valueOf(otp));
        o.setOtp_status("PENDING");
        o.setCreated_at(LocalDateTime.now());
        o.setExpires_at(LocalDateTime.now().plusMinutes(5));  // OTP Valid for 5 minutes

        repo.save(o);

        return "OTP sent to " + mobile + ": " + otp;
    }

    // 2. Verify OTP
    public String verifyOtp(String mobile, String otp) {

        OtpVerificationEntity o = repo.findTopByMobileOrderByIdDesc(mobile);

        if (o == null)
            return "Mobile number not found";

        if (o.getExpires_at().isBefore(LocalDateTime.now()))
            return "OTP expired, please request again";

        if (!o.getOtp_code().equals(otp))
            return "Invalid OTP";

        o.setOtp_status("VERIFIED");
        repo.save(o);

        return "OTP verified successfully";
    }

    // 3. Add User (only after OTP verified)
    public String addUser(String mobile, String name, String address) {

        OtpVerificationEntity o = repo.findTopByMobileOrderByIdDesc(mobile);

        if (o == null || !"VERIFIED".equals(o.getOtp_status())) {
            return "OTP not verified. Cannot add user.";
        }

        // Check if user already exists
        UserEntity existing = userRepo.findByMobile(mobile);
        if (existing != null) {
            existing.setName(name);
            existing.setAddress(address);
            userRepo.save(existing);
            return "User details updated successfully";
        }

        // Add new user
        UserEntity user = new UserEntity();
        user.setMobile(mobile);
        user.setName(name);
        user.setAddress(address);

        userRepo.save(user);

        return "User added successfully";
    }
}
