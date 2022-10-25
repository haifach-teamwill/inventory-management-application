package com.chagwey.springbootinventorymanagement.controller;

import com.chagwey.springbootinventorymanagement.controller.API.CategoryAPI;
import com.chagwey.springbootinventorymanagement.model.Category;
import com.chagwey.springbootinventorymanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:9000")
public class CategoryController implements CategoryAPI {
    @Autowired
    private CategoryService categoryService;

    @Override
    public Category save(Category category) {
        return categoryService.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
