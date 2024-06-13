package com.rivo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.rivo.gestiondestock.dto.UtilisateurDto;

public class UtilisateurValidator {
	
	public static List<String> validate(UtilisateurDto utilisateurDto){
		List<String> errors = new ArrayList<>();
		
		if (utilisateurDto == null) {
			errors.add("Veuillez renseigner le nom d'utilisateur");
			errors.add("Veuillez renseigner le nom d'utilisateur");
			errors.add("Veillez renseigner le mot de passe d'utilisateur");
			errors.add("Veillez renseigner l'adresse d'utilisateur");
		}
		
		if(!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom d'utilisateur");
		}
		
		if(!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veillez renseigner le prenom d'utilisateur");
		}
		
		if(!StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veillez renseigner l'email d'utilisateur");
		}
		
		if(!StringUtils.hasLength(utilisateurDto.getMoteDePasse())) {
			errors.add("Veillez renseigner le mot de passe d'utilisateur");
		}
		
		if(utilisateurDto.getDateDeNaissance() == null) {
			errors.add("Veillez renseigner la date de naissance d'utilisateur");
		}
		
		if(utilisateurDto.getAdresse() == null) {
			errors.add("Veillez renseigner l'adresse d'utilisateur");
			
		}else {
				
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
				errors.add("Le champ 'Adresse 1' est obligatoire");
			}
			
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
				errors.add("Le champ 'Ville' est obligatoire");
			}
			
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
				errors.add("Le champ 'Code postale' est obligatoire");
			}
			
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
				errors.add("Le champ 'Pays' est obligatoire");
			}
		}
		
		return errors;
		
	}

}
