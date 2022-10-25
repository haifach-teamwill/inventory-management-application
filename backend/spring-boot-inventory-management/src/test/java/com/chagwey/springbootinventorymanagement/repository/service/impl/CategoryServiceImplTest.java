package com.chagwey.springbootinventorymanagement.repository.service.impl;

import com.chagwey.springbootinventorymanagement.exception.EntityNotFoundException;
import com.chagwey.springbootinventorymanagement.exception.ErrorCode;
import com.chagwey.springbootinventorymanagement.exception.InvalidEntityException;
import com.chagwey.springbootinventorymanagement.model.Category;
import com.chagwey.springbootinventorymanagement.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

//execute unit tests with spring
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;


    @Test
    public void shouldSaveCategoryWithSuccess() {
        Category expectedCategory = Category.builder()
                .code("Category test")
                .description("Description test")
                .build();
        Category savedCategory = categoryService.save(expectedCategory);
        assertNotNull(savedCategory);
//        verify that hibenate generated an id for my category
        assertNotNull(savedCategory.getId());
//        verify that hibernate saved my category code
        assertEquals(expectedCategory.getCode(), savedCategory.getCode());
//        verify that hibernate saved my category description
        assertEquals(expectedCategory.getDescription(), savedCategory.getDescription());

    }

    @Test
    public void shouldUpdateCategoryWithSuccess() {
//      Add category
        Category expectedCategory = Category.builder()
                .code("Category test")
                .description("Description test")
                .build();
        Category savedCategory = categoryService.save(expectedCategory);
//        Update category
        Category categoryToUpdate = savedCategory;
        categoryToUpdate.setCode("Category update");
        savedCategory = categoryService.save(categoryToUpdate);

        assertNotNull(savedCategory);
//        verify that my category id has not changed
        assertNotNull(savedCategory.getId());
//        verify that my category code has changed
        assertEquals(expectedCategory.getCode(), savedCategory.getCode());
//        verify that my category description has not changed
        assertEquals(expectedCategory.getDescription(), savedCategory.getDescription());

    }

    @Test
    public void shouldThrowInvalidEntityException() {
        Category expectedCategory = Category.builder().build();
        InvalidEntityException expectedException =
                assertThrows(InvalidEntityException.class, () -> categoryService.save(expectedCategory));
        assertEquals(ErrorCode.CATEGORY_NOT_VALID, expectedException.getErrorCode());
        assertEquals(1, expectedException.getErrors().size());
        assertEquals("Please enter the category code", expectedException.getErrors().get(0));
    }

    @Test
    public void shouldThrowEntityNotException() {

        EntityNotFoundException expectedException =
                assertThrows(EntityNotFoundException.class, () -> categoryService.findById(0));
        assertEquals(ErrorCode.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("No article with id 0 was found.", expectedException.getMessage());

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotException2() {
        categoryService.findById(0);

    }


}