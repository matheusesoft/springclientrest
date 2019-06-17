package com.uol.clientrest.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uol.clientrest.persistence.model.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {
	public Cliente findClienteById(long id);
}
