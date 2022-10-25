package com.chagwey.springbootinventorymanagement.service;

import com.chagwey.springbootinventorymanagement.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category findById(Integer id);


    List<Category> findAll();

    void delete(Integer id);

}
