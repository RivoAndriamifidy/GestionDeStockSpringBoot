package com.rivo.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rivo.gestiondestock.controller.api.ArticleApi;
import com.rivo.gestiondestock.dto.ArticleDto;
import com.rivo.gestiondestock.dto.LigneCommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.rivo.gestiondestock.dto.LigneVenteDto;
import com.rivo.gestiondestock.services.ArticleService;

@RestController
public class ArticleController implements ArticleApi{

	private ArticleService articleService;
	
	@Autowired
	  public ArticleController(
	      ArticleService articleService
	  ) {
	    this.articleService = articleService;
	  }

	@Autowired
	public ArticleDto save(ArticleDto dto) {
		return articleService.save(dto);
	}
	
	@Autowired
	public ArticleDto findById(Integer id) {
		return articleService.findById(id);
	}
	
	@Autowired
	public ArticleDto findByCodeArticle(String codeArticle) {
		return articleService.findByCodeArticle(codeArticle);
	}
	
	@Autowired
	public List<ArticleDto> findAll() {
		return articleService.findAll();
	}
	
	@Autowired
	public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
		return articleService.findHistoriqueVentes(idArticle);
	}
	
	@Autowired
	public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {
		return articleService.findHistoriqueCommandeClient(idArticle);
	}
	
	@Autowired
	public List<LigneCommandeFournisseurDto> fingHistoriqueCommandeFournisseur(Integer idArtcile) {
		return articleService.fingHistoriqueCommandeFournisseur(idArtcile);
	}
	
	@Autowired
	public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
		return articleService.findAllArticleByIdCategory(idCategory);
	}

	@Autowired
	public void delete(Integer id) {
		articleService.delete(id);
		
	}
	
}
