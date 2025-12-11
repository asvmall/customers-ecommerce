package com.mahesh.asv_mall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.asv_mall.entity.NotificationEntity;
import com.mahesh.asv_mall.repository.NotifiactionRepository;
@Service
public class NotificationService {
	@Autowired
	NotifiactionRepository notifiactionRepository;
	public List<NotificationEntity>getAllData(){
		return notifiactionRepository.findAll();
	}
	public Optional<NotificationEntity> getById(Integer user_id) {
		return notifiactionRepository.findById(user_id);
	}

}
