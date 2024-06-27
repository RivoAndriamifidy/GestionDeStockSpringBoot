package com.rivo.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivo.gestiondestock.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

	Client save(Client entity);

	Optional<Client> findById(Integer id);

}
