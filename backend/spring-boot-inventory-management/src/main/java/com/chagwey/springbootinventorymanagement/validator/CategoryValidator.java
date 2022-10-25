package com.chagwey.springbootinventorymanagement.validator;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.model.Category;
import org.springframework.util.StringUtils;


public class CategoryValidator {

    public static List<String> validate(Category category) {
        List<String> errors = new ArrayList<>();
        if (category == null || !StringUtils.hasLength(category.getCode())) {
            errors.add("Please enter the category code");
        }
        return errors;

    }

}
