package com.rivo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Integer, Article>{

}
