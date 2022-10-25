package com.chagwey.springbootinventorymanagement.controller;

import java.util.List;

import com.chagwey.springbootinventorymanagement.controller.API.ArticleAPI;
import com.chagwey.springbootinventorymanagement.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.chagwey.springbootinventorymanagement.service.ArticleService;

import static org.springframework.http.HttpStatus.OK;


@CrossOrigin("*")
@RestController
@Slf4j
public class ArticleController implements ArticleAPI {


//	Field injection

    @Qualifier("ArticleServiceImpl")
    private ArticleService articleService;

//  Getter injection
//	@Autowired
//	public ArticleService getArticleservice() {
//		return articleService;
//	}

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @Override
    public ResponseEntity<List<Article>> findAll() {
        List<Article> articles = articleService.findAll();
        return new ResponseEntity<>(articles, OK);
    }

    @Override
    public ResponseEntity<Article> findById(Integer id) {
        Article article = articleService.findById(id);
        return new ResponseEntity<>(article, OK);

    }

    @Override
    public ResponseEntity<Article> save(Article article) {
        Article newArticle = articleService.save(article);
        return new ResponseEntity<>(newArticle, OK);
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }

}
