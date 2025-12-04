package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Users;
import com.asvmall.asvmall.models.UserPrincipal;
import com.asvmall.asvmall.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	public UsersRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepo.findByName(username);
		System.out.println(user +"&&"+  username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found");
      
		
	}
        return new UserPrincipal(user);
	}
}
