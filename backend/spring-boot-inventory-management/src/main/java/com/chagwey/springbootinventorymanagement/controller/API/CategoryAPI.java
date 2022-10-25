package com.chagwey.springbootinventorymanagement.controller.API;

import com.chagwey.springbootinventorymanagement.model.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/categories")
public interface CategoryAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Category save(@RequestBody Category category);

    @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Category findById(@PathVariable("categoryId") Integer id);


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Category> findAll();

    @DeleteMapping(value = "/categoryId", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("categoryId") Integer id);
}
