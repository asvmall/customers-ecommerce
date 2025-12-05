package com.shiva.Asvmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.Asvmall.entity.ProductEntity;
import com.shiva.Asvmall.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public List<ProductEntity> getProductsByCategoryId(int categoryId){
		return productRepository.findByCategoryId(categoryId);
	}

	

}
