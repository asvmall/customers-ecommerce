package com.mahesh.asv_mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.asv_mall.entity.WishListEntity;
@Repository
public interface WhishListRepository extends JpaRepository<WishListEntity, Integer>{

}
