package com.asvmall.asvmall.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Users;
import com.asvmall.asvmall.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService  {
    @Autowired
    private  UsersRepository usersRepository;

    

    
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

   
    public Users getUserById(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    
    public Users updateUser(int id, Users user) {
        Users existing = usersRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setMobile(user.getMobile());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());
        existing.setStatus(user.getStatus());

        return usersRepository.save(existing);
    }

    
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }
}

