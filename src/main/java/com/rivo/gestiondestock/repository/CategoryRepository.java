package com.rivo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Integer, Category> {

}
