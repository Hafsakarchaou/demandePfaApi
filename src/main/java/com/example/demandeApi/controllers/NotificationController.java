package com.example.demandeApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demandeApi.entities.Notification;
import com.example.demandeApi.services.DemandeService;
import com.example.demandeApi.services.NotificationService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

	@Autowired
	private NotificationService notifService;

	@GetMapping("/id/{userId}/{state}")
	public List<Notification> findByUser_IdAndState(@PathVariable Long userId,@PathVariable String state) {
		return notifService.findByUser_IdAndState(userId, state);
	}
	
	@GetMapping("/idcount/{userId}/{state}")
	public int countByUser_IdAndState(@PathVariable Long userId,@PathVariable String state) {
		return notifService.countByUser_IdAndState(userId, state);
	}

	@PutMapping("/updateState/{id}")
	public void updateStateNotification(@PathVariable int id) {
		notifService.updateStateNotification(id);
	}

	
	
	
}
