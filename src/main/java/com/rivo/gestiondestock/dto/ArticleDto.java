package com.rivo.gestiondestock.dto;

import java.math.BigDecimal;
import java.util.List;

import com.rivo.gestiondestock.model.Article;
import com.rivo.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {

	private Integer id;
	
	  private String codeArticle;

	  private String designation;

	  private BigDecimal prixUnitaireHt;

	  private BigDecimal tauxTva;

	  private BigDecimal prixUnitaireTtc;

	  private String photo;

	  private Integer idEntreprise;

	  private CategoryDto category;

	  private List<LigneVenteDto> ligneVentes;

	  private List<LigneCommandeClientDto> ligneCommandeClients;

	  private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

	  private List<MvtStkDto> mvtStks;
	  
	  public static ArticleDto fromEntity(Article article) {
		    if (article == null) {
		      return null;
		    }
		    return ArticleDto.builder()
		        .id(article.getId())
		        .codeArticle(article.getCodeArticle())
		        .designation(article.getDesignation())
		        .photo(article.getPhoto())
		        .prixUnitaireHt(article.getPrixUnitaireHt())
		        .prixUnitaireTtc(article.getPrixUnitaireTtc())
		        .tauxTva(article.getTauxTva())
		        .idEntreprise(article.getIdEntreprise())
		        .category(CategoryDto.fromEntity(article.getCategory()))
		        .build();
		  }

		  public static Article toEntity(ArticleDto articleDto) {
		    if (articleDto == null) {
		      return null;
		    }
		    Article article = new Article();
		    article.setId(articleDto.getId());
		    article.setCodeArticle(articleDto.getCodeArticle());
		    article.setDesignation(articleDto.getDesignation());
		    article.setPhoto(articleDto.getPhoto());
		    article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
		    article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
		    article.setTauxTva(articleDto.getTauxTva());
		    article.setIdEntreprise(articleDto.getIdEntreprise());
		    article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
		    return article;
		  }

}
