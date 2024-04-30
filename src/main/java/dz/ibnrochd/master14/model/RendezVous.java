package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.util.Date;

public class RendezVous implements Serializable {

	private static final long serialVersionUID = -7275578697948165342L;

    private int id;
    private Date dateRdv;
    private Patient patient;

    //////////////////////////////////////////////
    
    public RendezVous() {
		
	}

	public RendezVous(int id, Date dateRdv, Patient patient) {
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

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
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
