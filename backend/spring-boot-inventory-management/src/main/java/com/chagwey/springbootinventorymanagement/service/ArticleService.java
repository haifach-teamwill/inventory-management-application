package com.chagwey.springbootinventorymanagement.service;

import java.util.List;


import com.chagwey.springbootinventorymanagement.model.Article;

public interface ArticleService {

    Article save(Article article);

    Article update(Article article);

    Article findById(Integer id);

    Article findByCode(String codeArticle);

    List<Article> findAll();

    void delete(Integer id);
}