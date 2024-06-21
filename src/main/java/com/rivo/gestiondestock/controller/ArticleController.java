package com.rivo.gestiondestock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.rivo.gestiondestock.controller.api.ArticleApi;
import com.rivo.gestiondestock.dto.ArticleDto;
import com.rivo.gestiondestock.dto.LigneCommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.rivo.gestiondestock.dto.LigneVenteDto;

@RestController
public class ArticleController implements ArticleApi{


	public ArticleDto save(ArticleDto dto) {
		return null;
	}
	
	public ArticleDto findById(Integer id) {
		return null;
	}
	
	public ArticleDto findByCodeArticle(String codeArticle) {
		return null;
	}
	
	public List<ArticleDto> findAll() {
		return null;
	}
	
	public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
		return null;
	}
	
	public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {
		return null;
	}
	
	public List<LigneCommandeFournisseurDto> fingHistoriqueCommandeFournisseur(Integer idArtcile) {
		return null;
	}
	
	public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
