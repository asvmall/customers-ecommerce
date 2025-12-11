package com.mahesh.asv_mall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mahesh.asv_mall.entity.WishListEntity;
import com.mahesh.asv_mall.service.WhishListService;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wish")
public class WhishListControler {
	@Autowired
	WhishListService whishListService;
@GetMapping("/all")
public List<WishListEntity>get(){
	return whishListService.getAll();
}
@PostMapping("/save")
public WishListEntity getUserDetails(@RequestBody WishListEntity wish) {
	return whishListService.getUserData(wish);
}
@GetMapping("/{id}")
public Optional<WishListEntity> getID(@PathVariable Integer id) {
	return whishListService.getById(id);
}
}
