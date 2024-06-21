package com.rivo.gestiondestock.controller.api;

import java.util.List;
import static com.rivo.gestiondestock.services.utils.Constants.APP_ROOT;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rivo.gestiondestock.dto.ArticleDto;
import com.rivo.gestiondestock.dto.LigneCommandeClientDto;
import com.rivo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.rivo.gestiondestock.dto.LigneVenteDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("articles")
public interface ArticleApi {

	@PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer un article",notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet article créer / modifié"),
			@ApiResponse(code = 400, message = "L'objet article n'est pas valide")
	})
	ArticleDto save(@RequestBody ArticleDto dto);
	
	@GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rechercher un article par ID", notes = "Cette mehode permet de chercher un article par son ID", response = ArticleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'article a été trouvé dans la BDD"),
			@ApiResponse(code = 400, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
	})
	ArticleDto findById(@PathVariable("idArticle") Integer id);
	
	@GetMapping(value = APP_ROOT + "/articles/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rechercher un article par CODE", notes = "Cette methode permet de chercher un article par son CODE", response = ArticleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
			@ApiResponse(code = 400, message = "Aucun article n'existe dans la BDD avec le CODE fourni")
	})
	ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
	
	@GetMapping(value = APP_ROOT + "/artcile/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des artiles", notes = "Cette methode permet de chercher et renvoyer la liste des articles qui existent" + "dans la BDD", responseContainer = "List<ArticleDto>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La liste des articles / Une liste vide")
	})
	List<ArticleDto> findAll();
	
	@GetMapping(value = APP_ROOT + "/articles/historiques/vente/{idArticle}", produces = MediaType.APPLICATION_CBOR_VALUE)	
	List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);
	
	@GetMapping(value = APP_ROOT + "/articles/historiques/commandeclient/{idArticle}", produces = MediaType.APPLICATION_CBOR_VALUE)	
	List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);
	
	@GetMapping(value = APP_ROOT + "/articles/historiques/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_CBOR_VALUE)	
	List<LigneCommandeFournisseurDto> fingHistoriqueCommandeFournisseur(Integer idArtcile);
	
	@GetMapping(value = APP_ROOT + "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
	
	@DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
	@ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
	@ApiResponses(value = {
	      @ApiResponse(code = 200, message = "L'article a ete supprime")
	  })
	  void delete(@PathVariable("idArticle") Integer id);
}
