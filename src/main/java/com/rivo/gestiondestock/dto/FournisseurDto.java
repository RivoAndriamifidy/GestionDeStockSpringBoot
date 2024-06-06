package com.rivo.gestiondestock.dto;

import java.util.List;

import com.rivo.gestiondestock.model.Adresse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class FournisseurDto {

	private Integer id;
	
	
	  private String nom;

	  private String prenom;

	  private Adresse adresse;

	  private String photo;

	  private String mail;

	  private String numTel;

	  private Integer idEntreprise;

	  private List<CommandeFournisseurDto> commandeFournisseurs;
}
