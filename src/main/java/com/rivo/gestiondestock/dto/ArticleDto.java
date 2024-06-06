package com.rivo.gestiondestock.dto;

import java.math.BigDecimal;
import java.util.List;

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

	  private Category category;

	  private List<LigneVenteDto> ligneVentes;

	  private List<LigneCommandeClientDto> ligneCommandeClients;

	  private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

	  private List<MvtStkDto> mvtStks;

}
