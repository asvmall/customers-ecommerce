package com.example.asvmall_v1.repository;

import com.example.asvmall_v1.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {

    List<CartEntity> findByUserId(int userId);
    CartEntity findByUserIdAndProductProductId(int userId, int productId);
}
