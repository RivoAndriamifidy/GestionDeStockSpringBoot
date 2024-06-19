package com.rivo.gestiondestock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rivo.gestiondestock.dto.ArticleDto;
import com.rivo.gestiondestock.dto.LigneCommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.rivo.gestiondestock.dto.LigneVenteDto;
import com.rivo.gestiondestock.exception.ErrorCodes;
import com.rivo.gestiondestock.exception.InvalidEntityException;
import com.rivo.gestiondestock.model.LigneCommandeClient;
import com.rivo.gestiondestock.model.LigneCommandeFournisseur;
import com.rivo.gestiondestock.model.LigneVente;
import com.rivo.gestiondestock.repository.ArticleRepository;
import com.rivo.gestiondestock.repository.LigneCommandeClientRepository;
import com.rivo.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.rivo.gestiondestock.repository.LigneVenteRepository;
import com.rivo.gestiondestock.services.ArticleService;
import com.rivo.gestiondestock.validator.ArticleValidator;

import com.rivo.gestiondestock.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService{

	private ArticleRepository articleRepository;
	private LigneVenteRepository venteRepository;
	private LigneCommandeFournisseurRepository commandeFournisseurRepository;
	private LigneCommandeClientRepository commandeClientRepository;
	
	public ArticleServiceImpl(
			ArticleRepository articleRepository,
			LigneVenteRepository venteRepository,
			LigneCommandeFournisseurRepository commandeFournisseurRepository,
			LigneCommandeClientRepository commandeClientRepository){
		this.articleRepository = articleRepository;
		this.venteRepository = venteRepository;
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.commandeClientRepository = commandeClientRepository;		
	}
	
	@Override
	public ArticleDto save(ArticleDto dto) {
		List<String> errors = ArticleValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Article is not valid {}", dto);
			throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}
		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
	}

	@Override
	public ArticleDto findById(Integer id) {
		if(id == null) {
			log.error("Article ID is null");
			return null;
		}
		return articleRepository.findById(id)
				.map(ArticleDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Article avec l'ID = " + id + "n'a été trouvé dans la BDD",
						ErrorCodes.ARTICLE_NOT_FOUND) 
			);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if(!StringUtils.hasLength(codeArticle)) {
			log.error("Article CODE is null");
			return null;
		}
		return articleRepository.findArticleByCodeArticle(codeArticle)
				.map(ArticleDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Article avec le CODE = " + codeArticle + "n'a été trouvé dans la BDD",
						ErrorCodes.ARTICLE_NOT_FOUND) 
			);
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return articleRepository.findAll().stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList());
	}


	@Override
	public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
	
		return venteRepository.findAllByArticleId(idArticle).stream()
				.map(LigneVenteDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {
		
		return commandeClientRepository.findAllByArticleId(idArticle).stream()
				.map(LigneCommandeClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneCommandeFournisseurDto> fingHistoriqueCommandeFournisseur(Integer idArtcile) {
		
		return commandeFournisseurRepository.findAllByArticleId(idArtcile).stream()
				.map(LigneCommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
		
		return ArticleRepository.findByCategoryId(idCategory).stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public void delete(Integer id) {
		
		if(id == null) {
			log.error("Article ID is null");
			return;
		}
		
		List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
		if(!ligneCommandeClients.isEmpty()) {
			throw new InvalidEntityException("Impossible de supprimer un article deja utilisé dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
		}
		
		List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
		if(!ligneCommandeFournisseurs.isEmpty()) {
			throw new InvalidEntityException("Impossible de supprimer un article deja utilisé dans des commandes fournisseur", ErrorCodes.ARTICLE_ALREADY_IN_USE);
		}
		
		List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
		if(!ligneVentes.isEmpty()) {
			throw new InvalidEntityException("Impossible de supprimer un article deja utilise dans des ventes", ErrorCodes.ARTICLE_ALREADY_IN_USE);
		}
		
		articleRepository.deleteById(id);
		
	}

}
