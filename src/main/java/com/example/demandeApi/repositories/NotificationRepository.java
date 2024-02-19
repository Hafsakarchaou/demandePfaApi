package com.example.demandeApi.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demandeApi.entities.Demande;
import com.example.demandeApi.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

	Notification findById(int id);
	
	
	List<Notification> findByUser_IdAndState(Long userId, String state);
	int countByUser_IdAndState(Long userId, String state);
}
