package com.asvmall.ASV_Mall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asvmall.ASV_Mall.entity.ProfileEntity;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEntity, Long>{

}
