package com.shiva.Asvmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiva.Asvmall.entity.CategoriesEntity;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {

}
