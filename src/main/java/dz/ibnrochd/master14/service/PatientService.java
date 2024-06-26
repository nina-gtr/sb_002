package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.Patient;

@Service
public class PatientService {
	private final PatientMapper patientMapper;

    @Autowired
    public PatientService(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public void ListePatients() {
        List<Patient> patients = patientMapper.selectAllPatient();
        for (Patient patient : patients) {
            System.out.println("Patient N°" + patient.getId() + ": " + patient.getNom()); 
        }
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
    
   
    public void NewPatient(Patient patient) {
        patientMapper.ajouterPatient(patient);
        System.out.println("Un nouveau patient a été ajouté avec succès !!!");
    }
    
}
