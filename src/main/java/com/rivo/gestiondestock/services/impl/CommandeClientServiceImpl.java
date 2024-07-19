package com.rivo.gestiondestock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rivo.gestiondestock.dto.CommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.rivo.gestiondestock.exception.EntityNotFoundException;
import com.rivo.gestiondestock.exception.ErrorCodes;
import com.rivo.gestiondestock.exception.InvalidEntityException;
import com.rivo.gestiondestock.model.Article;
import com.rivo.gestiondestock.model.Client;
import com.rivo.gestiondestock.model.CommandeClient;
import com.rivo.gestiondestock.model.LigneCommandeClient;
import com.rivo.gestiondestock.repository.ArticleRepository;
import com.rivo.gestiondestock.repository.ClientRepository;
import com.rivo.gestiondestock.repository.CommandeClientRepository;
import com.rivo.gestiondestock.repository.LigneCommandeClientRepository;
import com.rivo.gestiondestock.services.CommandeClientService;
import com.rivo.gestiondestock.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService{

	private CommandeClientRepository commandeClientRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;
	
	@Autowired
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
			ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepositor, LigneCommandeClientRepository ligneCommandeClientRepository) {
		super();
		this.commandeClientRepository = commandeClientRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
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
		
		List<String> articleErrors = new ArrayList<>();
		
		if(dto.getLigneCommandeClients() != null) {
			dto.getLigneCommandeClients().forEach(ligCmdClt -> {
				if(ligCmdClt.getArticle() != null) {
					Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
					if(article.isEmpty()) {
						articleErrors.add("l'article ave l'ID" + ligCmdClt.getArticle().getId() + "n'existe pas");
					}
				}else {
					articleErrors.add("Impossible d'enregistrer une commande avec un article NULL");
				}
			});
		}
		
		if(!articleErrors.isEmpty()) {
			log.warn("");
			throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
		}
		
		CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
		
		if (dto.getLigneCommandeClients() != null) {
			dto.getLigneCommandeClients().forEach(ligCmdClt -> {
				LigneCommandeClient lignCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
				lignCommandeClient.setCommandeClient(savedCmdClt);
				ligneCommandeClientRepository.save(lignCommandeClient);
			});
		}
		
		return CommandeClientDto.fromEntity(savedCmdClt);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if(id == null) {
			log.error("Commande client ID is null");
			return null;
		}
		
		return commandeClientRepository.findById(id)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucune commande client n'a ete trouve avec le code"+ id,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
						);
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("Commande client code is null");
			return null;
		}
		
		return commandeClientRepository.findCommandeClientByCode(code)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucune commande client n'a ete trouve avec le code"+ code,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDto> findAll() {
		return commandeClientRepository.findAll().stream()
				.map(CommandeClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Commande client ID is NULL");
			return;
		}
		commandeClientRepository.deleteById(id);
		
	}

	
}
