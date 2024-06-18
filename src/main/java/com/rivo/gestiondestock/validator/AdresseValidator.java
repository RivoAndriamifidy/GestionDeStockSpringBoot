package com.rivo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.rivo.gestiondestock.dto.AdresseDto;
import com.rivo.gestiondestock.model.Adresse;

public class AdresseValidator {
	
	  public static List<String> validate(AdresseDto dto) {
		    List<String> errors = new ArrayList<>();

		    if (dto == null) {
		      errors.add("Veuillez renseigner l'adresse 1'");
		      errors.add("Veuillez renseigner la ville'");
		      errors.add("Veuillez renseigner le pays'");
		      errors.add("Veuillez renseigner le code postal'");
		      return errors;
		    }
		    if (!StringUtils.hasLength(dto.getAdresse1())) {
		      errors.add("Veuillez renseigner l'adresse 1'");
		    }
		    if (!StringUtils.hasLength(dto.getVille())) {
		      errors.add("Veuillez renseigner la ville'");
		    }
		    if (!StringUtils.hasLength(dto.getPays())) {
		      errors.add("Veuillez renseigner le pays'");
		    }
		    if (!StringUtils.hasLength(dto.getAdresse1())) {
		      errors.add("Veuillez renseigner le code postal'");
		    }
		    return errors;
		  }

}
