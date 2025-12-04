package com.asvmall.asvmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.asvmall.asvmall.entities.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}

