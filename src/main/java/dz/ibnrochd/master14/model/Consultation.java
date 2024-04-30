package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Consultation implements Serializable {

	private static final long serialVersionUID = -3669998604878710274L;
	Patient patient;
	

	private int id;
	private String  motif;
	private Timestamp dateconsult;
	private List<LigneConsultation> ligneconsultation = new ArrayList<>();
	
	public Consultation() {		
	}

	public Consultation(int id, String  motif, Timestamp dateconsult, Patient patient) {
		this.id = id;
		this.motif = motif;
		this.dateconsult = dateconsult;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Timestamp getDateConsult() {
		return dateconsult;
	}

	public void setDateConsult(Timestamp dateconsult) {
		this.dateconsult = dateconsult;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public List<LigneConsultation> getLigneConsultation() {
		return ligneconsultation;
	}

	public void setLigneConsultation(List<LigneConsultation> ligneconsultation) {
		this.ligneconsultation = ligneconsultation;
	}

    
}
