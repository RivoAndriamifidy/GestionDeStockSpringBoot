package com.rivo.gestiondestock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.rivo.gestiondestock.model.Article;
import com.rivo.gestiondestock.model.SourceMvtStk;
import com.rivo.gestiondestock.model.TypeMvtStk;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MvtStkDto {

	private Integer id;
	
	  private Instant dateMvt;

	  private BigDecimal quantite;

	  private Article article;

	  private TypeMvtStk typeMvt;

	  private SourceMvtStk sourceMvt;

	  private Integer idEntreprise;
}
