package com.rivo.gestiondestock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rivo.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Integer, Article>{
	
	@Query("select a from article where codearticl = :code and designation = :designation")
	List<Article> findByCustomQuery(@Param("code")String c, @Param("designation")String d);
	
	@Query(value = "select * from article where code = :code", nativeQuery = true)
	List<Article> findByCustomNativeQuery(@Param("code") String c);
	
	List<Article> findByCodeArticleIngoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);
	

}
