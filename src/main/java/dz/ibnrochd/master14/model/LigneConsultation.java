package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.util.Date;


public class LigneConsultation implements Serializable {

	private static final long serialVersionUID = -1882485395538957648L;
	
	private int id;
	Consultation consultation;
	Traitement traitement;
	
	private String posologie;
	private String unite_temps;
	private String quantite;
	
	public LigneConsultation() {		
	}

	public LigneConsultation(int id, String posologie, String unite_temps, String quantite, 
			Consultation consultation, Traitement traitement) {
		this.id = id;
		this.posologie = posologie;
		this.unite_temps = unite_temps;
		this.quantite = quantite;
		this.consultation = consultation;
		this.traitement = traitement;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosologie() {
		return posologie;
	}
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}
	public String getUnite_temps() {
		return unite_temps;
	}
	public void setUnite_temps(String unite_temps) {
		this.unite_temps = unite_temps;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	
	public Traitement getTraitement() {
		return traitement;
	}

	public void setTraitement(Traitement traitement) {
		this.traitement = traitement;
	}
    
}
