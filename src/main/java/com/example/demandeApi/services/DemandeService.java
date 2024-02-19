package com.example.demandeApi.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demandeApi.entities.Demande;
import com.example.demandeApi.entities.Notification;
import com.example.demandeApi.repositories.DemandeRepository;
import com.example.demandeApi.repositories.NotificationRepository;
import com.example.demandeApi.security.springjwt.models.ERole;
import com.example.demandeApi.security.springjwt.models.Role;
import com.example.demandeApi.security.springjwt.models.User;
import com.example.demandeApi.security.springjwt.repository.UserRepository;

@Service
public class DemandeService {
    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    NotificationRepository notifRepository;
    
    @Autowired
    NotificationService notifService;
    
    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    public void save(Demande entity) {
        Demande savedDemande = demandeRepository.save(entity);

        for (User user : userRepository.findAll()) {
            Set<Role> uRoles = user.getRoles();

            if (uRoles.stream().anyMatch(role -> role.getName() == ERole.ROLE_ADMIN)) {
                // Ensure the savedDemande is associated with the current session
                savedDemande = demandeRepository.getById(savedDemande.getId());

                notifService.save(new Notification("new", user, savedDemande, "new notification from user (Nouvelle demande demande)"));
                // Your logic for users with admin role
            } else {
                System.out.println("User with username " + user.getUsername() + " does not have admin role.");
                // Your logic for users without admin role
            }
        }
    }

    public Demande findById(int aLong) {
        return demandeRepository.findById(aLong);
    }

    public void delete(String id) {
    	int demandeId = Integer.parseInt(id);
    	Optional<Demande> optionalRed = Optional.of(demandeRepository.findById(demandeId));
	    if (optionalRed.isPresent()) {
	    	Demande demande = optionalRed.get();

	        List<Notification> notifs = demande.getNotifications();
	       
	        if (notifs != null) {
	            for (Notification not : notifs) {
	            	//terrain.setCategory(null);
	            	notifRepository.delete(not);
	            }
	            
	        }
	        demandeRepository.delete(demande);
	        
	    }
    }
    
	public void accept(String id) {
		int demandeId = Integer.parseInt(id);

        Optional<Demande> optionalDemande = Optional.of(demandeRepository.findById(demandeId));
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setEtat("acceptee");
            demandeRepository.save(existingDemande);
            notifService.save(new Notification("new", existingDemande.getUser(), existingDemande, "new notification from administration (Acceptation de votre demande)"));
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
	
	
	public void updatemotf(String id, Demande updatedDemande) {
	    int demandeId = Integer.parseInt(id);

	    Optional<Demande> optionalDemande = Optional.of(demandeRepository.findById(demandeId));
	    if (optionalDemande.isPresent()) {
	        Demande existingDemande = optionalDemande.get();

	        // Make sure the User entity is attached to the current session
	        User attachedUser = userRepository.getById(updatedDemande.getUser().getId());

	        existingDemande.setEtat("refusee");
	        existingDemande.setMotifRefus(updatedDemande.getMotifRefus());
	        existingDemande.setUser(attachedUser); // Set the attached User entity

	        demandeRepository.save(existingDemande);

	        notifService.save(new Notification("new", attachedUser, existingDemande, "new notification from administration (Refus de votre demande)"));
	    } else {
	        // Handle the case when the demande is not found
	    }
	}


 
    public List<Demande> findByUserId(Long userId) {
		return demandeRepository.findByUserId(userId);
	}

	public void update(String id, Demande updatedDemande) {
        int demandeId = Integer.parseInt(id);

        Optional<Demande> optionalDemande = Optional.of(demandeRepository.findById(demandeId));
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setEtat(updatedDemande.getEtat());
            existingDemande.setDes(updatedDemande.getDes());
            existingDemande.setDate(updatedDemande.getDate());
            //existingDemande.setType(id);
            existingDemande.setType(updatedDemande.getType());
            demandeRepository.save(existingDemande);
        } else {
            
        }
    }
}
