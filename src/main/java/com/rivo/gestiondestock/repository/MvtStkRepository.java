package com.rivo.gestiondestock.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rivo.gestiondestock.model.MvtStk;

public interface MvtStkRepository extends JpaRepository<Integer, MvtStk> {
	
	@Query("select sum(m.quantite) from MvtStk m where m.article.id = :idArticle")
	BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

	List<MvtStk> findAllByArticleId(Integer idArticle);

}
