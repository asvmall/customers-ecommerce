package com.shiva.Asvmall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shiva.Asvmall.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	@Query(value = "SELECT * FROM products WHERE category_id = :categoryId", nativeQuery = true)
	List<ProductEntity> findByCategoryId(@Param("categoryId") int categoryId);


}
