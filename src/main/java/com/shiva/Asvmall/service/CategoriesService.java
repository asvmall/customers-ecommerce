package com.shiva.Asvmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.Asvmall.entity.CategoriesEntity;
import com.shiva.Asvmall.repository.CategoriesRepository;

@Service
public class CategoriesService {
	@Autowired
	 private CategoriesRepository categoriesRepository;
	public List<CategoriesEntity> getAllCategories(){
		return categoriesRepository.findAll();
	}


}
