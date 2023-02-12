package com.chagwey.springbootinventorymanagement.controller.API;

import java.util.List;

import com.chagwey.springbootinventorymanagement.model.Article;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(path = "/articles")
public interface ArticleAPI {

        @ApiOperation(value = "Find all articles", notes = "This method allows you to retrieve all articles from DB", responseContainer = "List<Article>")
    @ApiResponses(value = {
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Article>> findAll();


        @ApiOperation(value = "Find article by id", notes = "This method allows you to search for an article by id", response = Article.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Articles found"),
            @ApiResponse(code = 404, message = "Article not found")
    })
    @GetMapping(value = "/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Article> findById(@PathVariable("idArticle") Integer id);

    //    @ApiOperation(value = "Save article", notes = "This method allows you to add or modify an article", response = Article.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Article added/modified successfully"),
//            @ApiResponse(code = 400, message = "Article not valid")
//    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Article> save(@RequestBody Article article);


        @ApiOperation(value = "Delete article", notes = "This method allows you to delete an article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article deleted successfully"),
    })
    @DeleteMapping(value = "/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idArticle") Integer id);


}
