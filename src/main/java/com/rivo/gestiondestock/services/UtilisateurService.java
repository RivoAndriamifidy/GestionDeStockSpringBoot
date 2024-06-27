package com.rivo.gestiondestock.services;

import java.util.List;

import com.rivo.gestiondestock.dto.ChangerMotDePasseUtilisateurDto;
import com.rivo.gestiondestock.dto.UtilisateurDto;

public interface UtilisateurService {

	  UtilisateurDto save(UtilisateurDto dto);

	  UtilisateurDto findById(Integer id);

	  List<UtilisateurDto> findAll();

	  void delete(Integer id);

	  UtilisateurDto findByEmail(String email);

	  UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


	}