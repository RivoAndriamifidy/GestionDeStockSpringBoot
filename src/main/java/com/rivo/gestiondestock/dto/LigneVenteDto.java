package com.rivo.gestiondestock.dto;

import java.math.BigDecimal;

import com.rivo.gestiondestock.model.Article;
import com.rivo.gestiondestock.model.Ventes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class LigneVenteDto {

	private Integer id;
	
	  private Ventes vente;

	  private Article article;

	  private BigDecimal quantite;

	  private BigDecimal prixUnitaire;

	  private Integer idEntreprise;
}
