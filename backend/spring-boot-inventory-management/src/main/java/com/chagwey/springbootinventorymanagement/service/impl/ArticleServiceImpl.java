package com.chagwey.springbootinventorymanagement.service.impl;

import java.util.List;
import java.util.Optional;

import com.chagwey.springbootinventorymanagement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chagwey.springbootinventorymanagement.repository.ArticleRepository;
import com.chagwey.springbootinventorymanagement.validator.ArticleValidator;
import com.chagwey.springbootinventorymanagement.exception.InvalidEntityException;
import com.chagwey.springbootinventorymanagement.model.Article;
import com.chagwey.springbootinventorymanagement.exception.EntityNotFoundException;
import com.chagwey.springbootinventorymanagement.exception.ErrorCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Service("ArticleServiceImpl")
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    //	constructor injection
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
//		return articleRepository.findAll().stream().map(ArticleDTO::fromEntity).collect(Collectors.toList());
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Integer id) {
//        if (id == null) {
//            log.error(" Article ID is null ");
//            return null;
//        }
        id = null;
        Optional<Article> article = articleRepository.findById(id);
        return article.orElseThrow(() -> new EntityNotFoundException("No article with id " + "  was found.",
                ErrorCode.ARTICLE_NOT_FOUND));
    }

    @Override
    public Article findByCode(String code) {
        log.info("code = " + code);
        if (!StringUtils.hasLength(code)) {
            log.error(" Article CODE is null ");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByCode(code);
        return article.orElseThrow(() -> new EntityNotFoundException("No article with code " + code + " was found.",
                ErrorCode.ARTICLE_NOT_FOUND));
    }

    @Override
    public Article save(Article article) {
        List<String> errors = ArticleValidator.validate(article);
        if (!errors.isEmpty()) {
            log.error("Article is not valid " + article);
            throw new InvalidEntityException("Article is not valid", ErrorCode.ARTICLE_NOT_VALID, errors);
            // InvalidEntityException(String message, ErrorCode errorCode, List<String>, errors)
        }
        log.info("article creation date" + article.getCreationDate());
        return articleRepository.save(article);
    }

    @Override
    public Article update(Article articleToUpdate) {
        Article article = this.findById(articleToUpdate.getId());

        List<String> errors = ArticleValidator.validate(article);
        if (!errors.isEmpty()) {
            log.error("Article is not valid " + article);
            throw new InvalidEntityException("Article is not valid", ErrorCode.ARTICLE_NOT_VALID, errors);
        }
        return articleRepository.save(article);
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }

}
