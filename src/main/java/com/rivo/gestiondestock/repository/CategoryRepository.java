package com.rivo.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Integer, Category> {
	
	Optional<Category> findCategoryByCode(String code);

}
