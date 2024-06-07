package com.rivo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rivo.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CategoryDto {

	private Integer id;
	
	  private String code;

	  private String designation;

	  private Integer idEntreprise;

	  @JsonIgnore
	  private List<ArticleDto> articles;
	  
	  public CategoryDto fromEntity(Category category) {
		  if(category == null) {
			  return null;
		  }
		  
	  }
	  
	  
}
