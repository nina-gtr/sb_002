package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Traitement implements Serializable {

	private static final long serialVersionUID = 8248365590951840055L;
    
	private int id;
	private String nom;
    private List<LigneConsultation> ligneconsultation = new ArrayList<>();
    
    public Traitement() {		
	}

	public Traitement(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<LigneConsultation> getLigneconsultation() {
		return ligneconsultation;
	}

	public void setLigneconsultation(List<LigneConsultation> ligneconsultation) {
		this.ligneconsultation = ligneconsultation;
	}
    
}
