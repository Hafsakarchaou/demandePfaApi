package com.example.demandeApi.entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demandeApi.security.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Notification")
public class Notification {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	private String state;
	 	
	 	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	 	@JoinColumn(name = "user_id")
	 	private User user;
	 	
	 	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	 	@JoinColumn(name = "demande_id")
	 	@JsonIgnoreProperties("notifications")
	 	private Demande demande;
	 	
	 	private String description;
	 	
		public Notification(String state, User user, Demande demande, String description) {
			super();
			this.state = state;
			this.user = user;
			this.demande = demande;
			this.description = description;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Demande getDemande() {
			return demande;
		}
		public void setDemande(Demande demande) {
			this.demande = demande;
		}
		public Notification(String state, User user, Demande demande) {
			super();
			this.state = state;
			this.user = user;
			this.demande = demande;
		}
		public Notification() {
			super();
		}
	
	 	
}
