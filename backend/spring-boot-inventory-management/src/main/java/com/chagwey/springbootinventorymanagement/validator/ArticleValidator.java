package com.chagwey.springbootinventorymanagement.validator;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.model.Article;
import org.springframework.util.StringUtils;


public class ArticleValidator {

    public static List<String> validate(Article article) {
        List<String> errors = new ArrayList<>();
        if (article == null) {
            errors.add("Please enter the article code");
            errors.add("Please enter the article description");
            errors.add("Please enter article the tax exclusive unit price");
            errors.add("Please enter article the tax inclusive unit price");
            errors.add("Please enter the article VAT rate");
            errors.add("Please select a category");
            return errors;
        }

        if (!StringUtils.hasLength(article.getCode())) {
            errors.add("Please enter the article code");
        }
        if (!StringUtils.hasLength(article.getDescription())) {
            errors.add("Please enter the article description");
        }
        if (article.getTaxExclUnitPrice() == null) {
            errors.add("Please enter article the tax exclusive unit price");
        }
        if (article.getTaxInclUnitPrice() == null) {
            errors.add("Please enter article the tax exclusive unit price");
        }
        if (article.getVatRate() == null) {
            errors.add("Please enter the article VAT rate");
        }
        if (article.getCategory() == null) {
            errors.add("Please select a category");
        }
        return errors;

    }
}