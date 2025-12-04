package com.asvmall.ASV_Mall.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asvmall.ASV_Mall.entity.ProfileEntity;
import com.asvmall.ASV_Mall.service.ProfileService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profile")
public class ProfileController {

	private final ProfileService profileService;
	
	public ProfileController(ProfileService p) {
		this.profileService=p;
	}
	
	@GetMapping("/test")
	private String test() {
		return "Okay!";
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<ProfileEntity> getProfile(@PathVariable Long id)
	{
		return profileService.getProfileInfo(id);
	}
	
	@PostMapping
	private ResponseEntity<ProfileEntity> addProfile(@RequestBody ProfileEntity profileEntity)
	{
		return profileService.addProfile(profileEntity);
	}
	
	@PatchMapping("/{id}")
	private ResponseEntity<ProfileEntity> updateProfile(@PathVariable Long id, @RequestBody Map<String,Object> updates)
	{
		return new ResponseEntity<>(profileService.updateProfile(id,updates),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	private ResponseEntity<ProfileEntity> deleteProfile(@PathVariable Long id)
	{
		return profileService.deleteProfile(id);
	}
}
