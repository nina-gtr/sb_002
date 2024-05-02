package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Patient;

@Mapper
public interface PatientMapper {
	
	void creerPatient( Patient patient );
	Patient lirePatient(int id);
	void mettreAjourPatient( Patient patient );
	void supprimerPatient( int id );
	
	
	////Patient findPatientWithConsultationsById(int id);
    List<Patient> selectAllPatient();
    List<Patient> RechParNom(String nom);
    void ajouterPatient(Patient patient);
 
}
