package com.rivo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.rivo.gestiondestock.model.Client;
import com.rivo.gestiondestock.model.EtatCommande;
import com.rivo.gestiondestock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CommandeClientDto {

	
	private Integer id;
	
	  private String code;

	  private Instant dateCommande;

	  private EtatCommande etatCommande;

	  private Integer idEntreprise;

	  private Client client;

	  private List<LigneCommandeClientDto> ligneCommandeClients;
}
