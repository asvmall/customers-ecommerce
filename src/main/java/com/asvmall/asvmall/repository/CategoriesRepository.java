package com.asvmall.asvmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.asvmall.asvmall.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}

