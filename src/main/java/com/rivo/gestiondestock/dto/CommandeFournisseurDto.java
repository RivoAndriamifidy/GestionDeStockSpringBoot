package com.rivo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.rivo.gestiondestock.model.EtatCommande;
import com.rivo.gestiondestock.model.Fournisseur;


public class CommandeFournisseurDto {

	private Integer id;
	
	  private String code;

	  private Instant dateCommande;

	  private EtatCommande etatCommande;

	  private Integer idEntreprise;

	  private Fournisseur fournisseur;

	  private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
}
