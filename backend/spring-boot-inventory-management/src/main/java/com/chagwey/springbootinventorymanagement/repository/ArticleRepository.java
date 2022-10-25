package com.chagwey.springbootinventorymanagement.repository;

	
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.Article;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface ArticleRepository extends JpaRepository< Article,Integer> {

	Optional<Article> findArticleByCode(String code);

//	@Query(" select a from article where code = : code and designation = : designation ")
//	List<Article> findByCustomQuery(@Param(" code ") String c, @Param(" designation ") String d);
//
//	@Query(value = " select from article where code = : code ", nativeQuery = true)
//	List<Article> findByCustomNativeQuery(@Param(" code ") String c);
//
//	List<Article> findByCodeIgnoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);

}
