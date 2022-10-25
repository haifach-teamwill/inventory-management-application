package com.chagwey.springbootinventorymanagement.service.impl;

import com.chagwey.springbootinventorymanagement.exception.EntityNotFoundException;
import com.chagwey.springbootinventorymanagement.exception.ErrorCode;
import com.chagwey.springbootinventorymanagement.exception.InvalidEntityException;
import com.chagwey.springbootinventorymanagement.model.Category;
import com.chagwey.springbootinventorymanagement.repository.CategoryRepository;
import com.chagwey.springbootinventorymanagement.service.CategoryService;
import com.chagwey.springbootinventorymanagement.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Integer id) {
        if (id == null) {
            log.info("Catgeory ID is null");
            return null;
        }
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No article with id " + id + " was found.", ErrorCode.CATEGORY_NOT_FOUND));

    }

    public Category findByCode(String code) {
        if (code == null) {
            log.info("Category code is null");
            return null;
        }
        return categoryRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("No article with code " + code + " was found.", ErrorCode.CATEGORY_NOT_FOUND));

    }

    @Override
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.info("Catgeory ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public Category save(Category category) {
        List<String> errors = CategoryValidator.validate(category);
        if (!errors.isEmpty()) {
            log.error("Catgeory is not valid");
            throw new InvalidEntityException("Category is not valid", ErrorCode.CATEGORY_NOT_VALID, errors);
        }
        return categoryRepository.save(category);
    }
}
