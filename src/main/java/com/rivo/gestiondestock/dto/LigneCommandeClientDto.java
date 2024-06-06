package com.rivo.gestiondestock.dto;

import java.math.BigDecimal;

import com.rivo.gestiondestock.model.Article;
import com.rivo.gestiondestock.model.CommandeClient;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LigneCommandeClientDto {

	
	private Integer id;

	  private Article article;
	  
	  private CommandeClient commandeClient;

	  private BigDecimal quantite;
	  
	  private BigDecimal prixUnitaire;
	  
	  private Integer idEntreprise;
}
