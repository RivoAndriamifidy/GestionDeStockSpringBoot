package com.rivo.gestiondestock.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivo.gestiondestock.dto.CommandeClientDto;
import com.rivo.gestiondestock.exception.EntityNotFoundException;
import com.rivo.gestiondestock.exception.ErrorCodes;
import com.rivo.gestiondestock.exception.InvalidEntityException;
import com.rivo.gestiondestock.model.Client;
import com.rivo.gestiondestock.repository.ArticleRepository;
import com.rivo.gestiondestock.repository.ClientRepository;
import com.rivo.gestiondestock.repository.CommandeClientRepository;
import com.rivo.gestiondestock.services.CommandeClientService;
import com.rivo.gestiondestock.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService{

	private CommandeClientRepository commandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;
	
	@Autowired
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
			ClientRepository clientRepository, ArticleRepository articleRepository) {
		super();
		this.commandeClientRepository = commandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public CommandeClientDto save(CommandeClientDto dto) {
		List<String> errors = CommandeClientValidator.validate(dto);
		
		if(!errors.isEmpty()) {
			log.error("Commande client n'est pas valide");
			throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
		}
		
		Optional<Client> client = clientRepository.findById(dto.getClient().getId());
		if(client.isEmpty()) {
			log.warn("Client with ID {} was not found in the DB", + dto.getClient().getId());
			throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getClient().getId() +"n'a ete trouve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND);
		}
		return null;
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandeClientDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
