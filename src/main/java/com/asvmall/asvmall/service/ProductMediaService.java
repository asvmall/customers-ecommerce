package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.ProductMedia;
import com.asvmall.asvmall.repository.ProductMediaRepository;

import java.util.List;

@Service
public class ProductMediaService {

    @Autowired
    private ProductMediaRepository productMediaRepository;

    
    public ProductMedia createMedia(ProductMedia media) {
        return productMediaRepository.save(media);
    }

    public ProductMedia getMediaById(int id) {
        return productMediaRepository.findById(id).orElse(null);
    }

    
    public List<ProductMedia> getAllMedia() {
        return productMediaRepository.findAll();
    }

    
    public ProductMedia updateMedia(int id, ProductMedia media) {
        ProductMedia existing = productMediaRepository.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setProduct_id(media.getProduct_id());
        existing.setType(media.getType());
        existing.setUrl(media.getUrl());

        return productMediaRepository.save(existing);
    }

    
    public void deleteMedia(int id) {
        productMediaRepository.deleteById(id);
    }
}

