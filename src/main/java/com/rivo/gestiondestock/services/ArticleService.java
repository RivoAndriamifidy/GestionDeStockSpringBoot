package com.rivo.gestiondestock.services;

import java.util.List;

import com.rivo.gestiondestock.dto.ArticleDto;
import com.rivo.gestiondestock.dto.LigneCommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.rivo.gestiondestock.dto.LigneVenteDto;

public interface ArticleService {

	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);
	
	List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);
	
	List<LigneCommandeFournisseurDto> fingHistoriqueCommandeFournisseur(Integer idArtcile);
	
	List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
	
	void delete(Integer id);
}
