package com.shiva.Asvmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shiva.Asvmall.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByMobile(String mobile);
}
