package com.mahesh.asv_mall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.asv_mall.entity.WishListEntity;
import com.mahesh.asv_mall.repository.WhishListRepository;

@Service
public class WhishListService {
	@Autowired
	WhishListRepository whishListRepository;
	public List<WishListEntity> getAll(){
		return whishListRepository.findAll();
	}
	public WishListEntity getUserData(WishListEntity user) {
		return whishListRepository.save(user);
	}
	public Optional<WishListEntity> getById( Integer user_id) {
		return whishListRepository.findById(user_id);
	}
}
