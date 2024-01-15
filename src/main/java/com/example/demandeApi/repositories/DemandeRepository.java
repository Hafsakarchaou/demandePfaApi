package com.example.demandeApi.repositories;

import com.example.demandeApi.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande, Integer> {
	Demande findById(int id);
}
