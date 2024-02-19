package com.example.demandeApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demandeApi.entities.Notification;
import com.example.demandeApi.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
    NotificationRepository notificationRepository;

	public Notification findById(int id) {
		return notificationRepository.findById(id);
	}

	public int countByUser_IdAndState(Long userId, String state) {
		return notificationRepository.countByUser_IdAndState(userId, state);
	}
	 
	public List<Notification> findByUser_IdAndState(Long userId, String state) {
		return notificationRepository.findByUser_IdAndState(userId, state);
	}
	
	
	//updateStateNotification

public void updateStateNotification(int id) {
	Notification n = notificationRepository.findById(id);
	n.setState("seen");
}

	



	public Notification save(Notification entity) {
		return notificationRepository.save(entity);
	}
	
	
}
