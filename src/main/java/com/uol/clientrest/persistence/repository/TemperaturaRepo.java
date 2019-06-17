package com.uol.clientrest.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uol.clientrest.persistence.model.Temperatura;

@Repository
public interface TemperaturaRepo extends JpaRepository<Temperatura, Long>{

}
