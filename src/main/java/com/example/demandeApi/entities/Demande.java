package com.example.demandeApi.entities;

import com.example.demandeApi.security.springjwt.models.User;

import javax.persistence.*;

import java.time.LocalDate;


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
    
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
	public int getId() {
		return id;
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
