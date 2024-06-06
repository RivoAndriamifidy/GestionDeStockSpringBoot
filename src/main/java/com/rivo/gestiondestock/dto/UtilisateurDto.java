package com.rivo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.rivo.gestiondestock.model.Adresse;
import com.rivo.gestiondestock.model.Entreprise;

public class UtilisateurDto {

	private Integer id;
	  private String nom;

	  private String prenom;

	  private String email;

	  private Instant dateDeNaissance;

	  private String moteDePasse;

	  private AdresseDto adresse;

	  private String photo;

	  private EntrepriseDto entreprise;

	  private List<RolesDto> roles;
}
