package com.rivo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.MvtStk;

public interface MvtStkRepository extends JpaRepository<Integer, MvtStk> {

}
