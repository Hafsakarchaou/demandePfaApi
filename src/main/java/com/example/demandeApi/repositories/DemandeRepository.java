package com.example.demandeApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demandeApi.entities.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer> {
	Demande findById(int id);
	List<Demande> findByUserId(Long userId);
}
