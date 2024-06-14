package com.rivo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {

}
