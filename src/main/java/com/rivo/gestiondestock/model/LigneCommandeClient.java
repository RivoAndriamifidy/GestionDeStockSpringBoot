package com.rivo.gestiondestock.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "idarticle")
	private Article artcile;
	
	@ManyToOne
	@JoinColumn(name = "idcommandeclient")
	private CommandeClient commendeClient;

}
