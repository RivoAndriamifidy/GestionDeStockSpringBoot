package com.rivo.gestiondestock.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rivo.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	Optional<Article> findArticleByCodeArticle(String codeArticle);

	static List<Article> findByCategoryId(Integer idCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	List<Article> findAllByCategoryId(Integer id);
	

}
