package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RendezVous implements Serializable {

	private static final long serialVersionUID = -7275578697948165342L;

    private int id;
    private Timestamp dateRdv;
    
	private Patient patient;

    //////////////////////////////////////////////
    
    public RendezVous() {
		
	}

	public RendezVous(int id, Timestamp dateRdv, Patient patient) {
		super();
		this.id = id;
		this.dateRdv = dateRdv;
		this.patient = patient;
	}

	///////////////////////////////////////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Timestamp dateRdv) {
		this.dateRdv = dateRdv;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
    
	@Override
	  public String toString() {      
		  return String.format("RDV { id= %d, date= %d }", 
				   id, dateRdv);  
		  }
}
