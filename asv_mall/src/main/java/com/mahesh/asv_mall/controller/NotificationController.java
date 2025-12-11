package com.mahesh.asv_mall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.asv_mall.entity.NotificationEntity;
import com.mahesh.asv_mall.service.NotificationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gets")
public class NotificationController {
	@Autowired
	NotificationService notificationService;
	@GetMapping("/all")
	public List<NotificationEntity>get(){
	return notificationService.getAllData();

}
	@GetMapping("/{id}")
	public Optional<NotificationEntity> getId(@PathVariable Integer id) {
		return notificationService.getById(id);
	}
}
