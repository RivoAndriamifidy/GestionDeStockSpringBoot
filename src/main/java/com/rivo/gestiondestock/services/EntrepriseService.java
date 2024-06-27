package com.rivo.gestiondestock.services;

import java.util.List;

import com.rivo.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseService {

	  EntrepriseDto save(EntrepriseDto dto);

	  EntrepriseDto findById(Integer id);

	  List<EntrepriseDto> findAll();

	  void delete(Integer id);

	}
