package com.example.demandeApi.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demandeApi.security.springjwt.models.User;


@Entity
@Table(name = "Demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String des;
    private String type;
    private LocalDate date;
    private String etat;
    private String motifRefus;
    @OneToMany(mappedBy = "demande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Notification> notifications;

    
    
    
    public Demande(String des, String type, LocalDate date, String etat, String motifRefus,
			List<Notification> notifications, User user) {
		super();
		this.des = des;
		this.type = type;
		this.date = date;
		this.etat = etat;
		this.motifRefus = motifRefus;
		this.notifications = notifications;
		this.user = user;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public String getMotifRefus() {
		return motifRefus;
	}
	public void setMotifRefus(String motifRefus) {
		this.motifRefus = motifRefus;
	}
	@ManyToOne(fetch = FetchType.EAGER)
    private User user;
	public int getId() {
		
		return id;
	}
	
	public Demande(int id, String des, String type, LocalDate date, String etat, String motifRefus, User user) {
		super();
		this.id = id;
		this.des = des;
		this.type = type;
		this.date = date;
		this.etat = etat;
		this.motifRefus = motifRefus;
		this.user = user;
	}
	public Demande(String des, String type, LocalDate date, String etat, String motifRefus, User user) {
		super();
		this.des = des;
		this.type = type;
		this.date = date;
		this.etat = etat;
		this.motifRefus = motifRefus;
		this.user = user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Demande(String des, String type, LocalDate date, String etat, User user) {
		super();
		this.des = des;
		this.type = type;
		this.date = date;
		this.etat = etat;
		this.user = user;
	}
	public Demande() {
		super();
	}
    
    
}
