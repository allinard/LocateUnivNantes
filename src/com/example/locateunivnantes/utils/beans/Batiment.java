package com.example.locateunivnantes.utils.beans;

import java.util.ArrayList;
import java.util.List;

public class Batiment {
	
	private List<Salle> salles;
	
	private String numero;

	public Batiment() {
		this.salles = new ArrayList<Salle>();
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void addSalle(Salle s) {
		this.salles.add(s);
	}

}
