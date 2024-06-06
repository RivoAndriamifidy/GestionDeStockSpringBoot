package com.rivo.gestiondestock.dto;

import java.math.BigDecimal;

import com.rivo.gestiondestock.model.Article;
import com.rivo.gestiondestock.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

	private Integer id;
	
	  private Article article;

	  private CommandeFournisseur commandeFournisseur;

	  private BigDecimal quantite;

	  private BigDecimal prixUnitaire;

	  private Integer idEntreprise;
}
