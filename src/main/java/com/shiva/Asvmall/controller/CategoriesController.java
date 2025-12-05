package com.shiva.Asvmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.Asvmall.entity.CategoriesEntity;
import com.shiva.Asvmall.service.CategoriesService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products-categories")
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;
	@GetMapping("/all")
	public List<CategoriesEntity>getAll(){
		return categoriesService.getAllCategories();
	}


}
