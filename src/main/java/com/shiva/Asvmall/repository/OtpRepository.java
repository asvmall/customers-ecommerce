package com.shiva.Asvmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.Asvmall.entity.OtpVerificationEntity;

public interface OtpRepository extends JpaRepository<OtpVerificationEntity, Integer> {
	OtpVerificationEntity findTopByMobileOrderByIdDesc(String mobile);

}
