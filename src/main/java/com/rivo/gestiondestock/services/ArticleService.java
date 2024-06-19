package com.rivo.gestiondestock.services;

import java.util.List;

import com.rivo.gestiondestock.dto.ArticleDto;

public interface ArticleService {

	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete(Integer id);
}
