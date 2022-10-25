package com.chagwey.springbootinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByCode(String code);
}
