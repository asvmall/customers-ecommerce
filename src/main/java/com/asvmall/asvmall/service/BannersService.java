package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Banners;
import com.asvmall.asvmall.repository.BannersRepository;

import java.util.List;

@Service
public class BannersService {

    @Autowired
    private BannersRepository bannersRepository;

    public Banners createBanner(Banners banner) {
        return bannersRepository.save(banner);
    }

    public Banners getBannerById(int id) {
        return bannersRepository.findById(id).orElse(null);
    }

    public List<Banners> getAllBanners() {
        return bannersRepository.findAll();
    }

    public Banners updateBanner(int id, Banners banner) {
        Banners existing = bannersRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(banner.getTitle());
        existing.setImage_url(banner.getImage_url());
        existing.setRecord_status(banner.getRecord_status());

        return bannersRepository.save(existing);
    }

    public void deleteBanner(int id) {
        bannersRepository.deleteById(id);
    }
}

