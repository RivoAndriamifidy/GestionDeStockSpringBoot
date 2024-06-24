package com.rivo.gestiondestock.services;

import java.util.List;

import com.rivo.gestiondestock.dto.ClientDto;

public interface ClientService {

	  ClientDto save(ClientDto dto);

	  ClientDto findById(Integer id);

	  List<ClientDto> findAll();

	  void delete(Integer id);

	}
