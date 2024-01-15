package com.example.demandeApi.controllers;

import com.example.demandeApi.entities.Demande;
import com.example.demandeApi.services.DemandeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    @Autowired
    DemandeService demandeService;
    @GetMapping("")
    public List<Demande> findAll() {
        return demandeService.findAll();
    }
    @PostMapping("")
    public Demande save(@RequestBody Demande entity) {
        return demandeService.save(entity);
    }
    @GetMapping("/id/{id}")
    public Demande findById(@PathVariable int id) {
        return demandeService.findById(id);
    }
    @DeleteMapping("id/{id}")
    public void deleteById(int aLong) {
        demandeService.deleteById(aLong);
    }
    
    @PutMapping("/update/{id}")
	public void update(@PathVariable String id, @RequestBody Demande o) {
    	demandeService.update(id, o);
	}
    @PutMapping("/accept/{id}")
	public void accept(@PathVariable String id) {
		demandeService.accept(id);
	}
    @PutMapping("/refus/{id}")
	public void refus(@PathVariable String id) {
		demandeService.refus(id);
	}
    
    
}
