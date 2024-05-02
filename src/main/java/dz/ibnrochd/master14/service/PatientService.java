package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;

@Service
public class PatientService {
	private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public List<Patient> ListePatients() {
        List<Patient> patients = patientMapper.selectAllPatient();
        for (Patient patient : patients) {
            System.out.println("Patient N°" + patient.getId() + ": " + patient.getNom()); 
        }
        return patients;
    }
    
    public void RechercherParNom(String nom) {
        List<Patient> Nom = patientMapper.RechParNom(nom);

        if (Nom.isEmpty()) {
            System.out.println("Aucun patient trouvé avec le nom '" + nom + "'.");
        } else {
            System.out.println("Patients trouvés portant le nom : '" + nom + "':");
            for (Patient patient : Nom) {
                System.out.println("	Prénom: " + patient.getPrenom());
                
            }
        }
    }
        
    public void CreerPatient(Patient patient) {
    	patientMapper.creerPatient(patient);
        System.out.println("Un nouveau patient a été ajouté avec succès !!!");
	}
	
	public Patient LirePatient(int id) {
		return patientMapper.lirePatient(id);
	}
	
	public void MettreAjourPatient(Patient patient) {
		patientMapper.mettreAjourPatient(patient);
		System.out.println("Le patient est mis à jour avec succès !!!");
	}
	
	public void SupprimerPatient(int id) {
		patientMapper.supprimerPatient(id);
		System.out.println("Patient supprimé avec succès !!!");
	}
    
}
