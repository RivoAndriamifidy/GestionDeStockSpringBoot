package com.rivo.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {

	void deleteById(Integer id);

	Entreprise save(Entreprise entity);

	Optional<Integer> findById(Integer id);

}
