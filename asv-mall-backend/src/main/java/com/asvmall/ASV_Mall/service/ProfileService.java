package com.asvmall.ASV_Mall.service;

import java.util.Map;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asvmall.ASV_Mall.entity.ProfileEntity;
import com.asvmall.ASV_Mall.repo.ProfileRepo;

@Service
public class ProfileService {

	private final ProfileRepo profileRepo;
	
	public ProfileService(ProfileRepo profile) {
		this.profileRepo=profile;
	}
	
	public ResponseEntity<ProfileEntity> getProfileInfo(Long id)
	{
		Optional<ProfileEntity> profile=profileRepo.findById(id);
		return profile.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<ProfileEntity> addProfile(ProfileEntity profileEntity)
	{
		profileRepo.save(profileEntity);
		return new ResponseEntity<>(profileEntity,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ProfileEntity> deleteProfile(Long id)
	{
		profileRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public ProfileEntity updateProfile(Long id,Map<String, Object> updates)
	{
		ProfileEntity existingData = profileRepo.findById(id)
				.orElseThrow();
		updates.forEach((key,value)->{
			switch(key) {
			case "name":
				existingData.setName((String) value);
				break;
			case "mobile":
				existingData.setMobile((String) value);
				break;
			case "address":
				existingData.setAddress((String) value);
				break;
			}
		});
		return profileRepo.save(existingData);
	}
	
	
}
