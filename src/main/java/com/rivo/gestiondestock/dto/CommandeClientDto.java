package com.rivo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.rivo.gestiondestock.model.Client;
import com.rivo.gestiondestock.model.CommandeClient;
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

	  private ClientDto client;

	  private List<LigneCommandeClientDto> ligneCommandeClients;
	  
	  public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		    if (commandeClient == null) {
		      return null;
		    }
		    return CommandeClientDto.builder()
		        .id(commandeClient.getId())
		        .code(commandeClient.getCode())
		        .dateCommande(commandeClient.getDateCommande())
		        .etatCommande(commandeClient.getEtatCommande())
		        
		        .idEntreprise(commandeClient.getIdEntreprise())
		        .client(ClientDto.fromEntity(commandeClient.getClient()))
		        .build();

		  }

		  public static CommandeClient toEntity(CommandeClientDto dto) {
		    if (dto == null) {
		      return null;
		    }
		    CommandeClient commandeClient = new CommandeClient();
		    commandeClient.setId(dto.getId());
		    commandeClient.setCode(dto.getCode());
		    commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
		    commandeClient.setDateCommande(dto.getDateCommande());
		    commandeClient.setEtatCommande(dto.getEtatCommande());
		    commandeClient.setIdEntreprise(dto.getIdEntreprise());
		    return commandeClient;
		  }

		  public boolean isCommandeLivree() {
		    return EtatCommande.LIVREE.equals(this.etatCommande);
		  }
}
