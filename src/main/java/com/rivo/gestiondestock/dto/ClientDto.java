package com.rivo.gestiondestock.dto;

import java.util.List;

import com.rivo.gestiondestock.model.Adresse;
import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

	private Integer id;
	
	  private String nom;

	  private String prenom;

	  private AdresseDto adresse;

	  private String photo;

	  private String mail;

	  private String numTel;

	  private Integer idEntreprise;

	  private List<CommandeClientDto> commandeClients;
}
