package com.garage.garage_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car{
	
	@Id
	private String immatriculation;
	
	@Column (nullable = false)
	private String marque;
	
	@Column (nullable = false)
	private String modele;
	
	@Column (nullable = false)
	private String etat;
	
	// Constructor
	public Car() {
		
	}
	
	public Car(String immatriculation, String marque, String modele, String etat) {
		
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.etat = etat;
	}
	
	// Getters
	
	public String getImmatriculation() {
		return this.immatriculation;
	}
	
	public String getMarque() {
		return this.marque;
	}
	
	public String getModele() {
		return this.modele;
	}
	
	public String getEtat() {
		return this.etat;
	}
	
	// Setters
	
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	

}