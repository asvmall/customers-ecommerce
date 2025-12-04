package com.asvmall.asvmall.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Categories;
import com.asvmall.asvmall.repository.CategoriesRepository;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

   
    public Categories createCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    
    public Categories getCategoryById(int id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

   
    public Categories updateCategory(int id, Categories category) {
        Categories existing = categoriesRepository.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setCategory_name(category.getCategory_name());
        existing.setRecord_status(category.getRecord_status());

        return categoriesRepository.save(existing);
    }

    
    public void deleteCategory(int id) {
        categoriesRepository.deleteById(id);
    }
}

