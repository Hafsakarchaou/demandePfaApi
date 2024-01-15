package com.example.demandeApi.services;

import com.example.demandeApi.entities.Demande;
import com.example.demandeApi.repositories.DemandeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {
    @Autowired
    DemandeRepository demandeRepository;

    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    public Demande  save(Demande entity) {
        return demandeRepository.save(entity);
    }

    public Demande findById(int aLong) {
        return demandeRepository.findById(aLong);
    }

    public void deleteById(int aLong) {
        demandeRepository.deleteById(aLong);
    }
    
	public void accept(String id) {
		int demandeId = Integer.parseInt(id);

        Optional<Demande> optionalDemande = Optional.of(demandeRepository.findById(demandeId));
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setEtat("acceptee");
            demandeRepository.save(existingDemande);
        } else {
            
        }
	}
	
	public void refus(String id) {
		int demandeId = Integer.parseInt(id);

        Optional<Demande> optionalDemande = Optional.of(demandeRepository.findById(demandeId));
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setEtat("refusee");
            demandeRepository.save(existingDemande);
        } else {
            
        }
	}
    public void update(String id, Demande updatedDemande) {
        int demandeId = Integer.parseInt(id);

        Optional<Demande> optionalDemande = Optional.of(demandeRepository.findById(demandeId));
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setEtat(updatedDemande.getEtat());
            
            existingDemande.setType(updatedDemande.getType());
            demandeRepository.save(existingDemande);
        } else {
            
        }
    }
}
