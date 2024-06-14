package com.rivo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<Integer, CommandeClient>{

}
