package dz.ibnrochd.master14.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.ConsultationMapper;
import dz.ibnrochd.master14.model.Consultation;

@Service
public class ConsultationService {

	private final ConsultationMapper consultationMapper;

    @Autowired
    public ConsultationService(ConsultationMapper consultationMapper) {
        this.consultationMapper = consultationMapper;
    }
    
	public void RechercherParId(int id) {
        List<Consultation> Id = consultationMapper.findConsultationsById(id);

        if (Id.isEmpty()) {
            System.out.println("Aucune consultation trouvée avec l'id '" + id + "'.");
        } else {
            System.out.println("La consultation ayant l'id '" + id + "':");
           

            for (Consultation consultation : Id) {
            	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                 String dateConsult = consultation.getDateConsult() != null ? dateFormat.format(consultation.getDateConsult()) : "";
                 System.out.println("	"+
                		"Consultation{" +
                        "id :" + consultation.getId() +
                        ", motif :'" + consultation.getMotif() + '\'' +
                        ", Date de consultation :" + dateConsult+
                        '}');
            }
        }
    }
	
	public void CreerConsultation(Consultation consultation) {
		consultationMapper.creerConsultation(consultation);
        System.out.println("Consultation ajoutée avec succès !!!");
	}
	
	public Consultation LireConsultation(int id) {
		return consultationMapper.lireConsultation(id);
	}
	
	public void MettreAjourConsultation(Consultation consultation) {
		consultationMapper.mettreAjourConsultation(consultation);
		System.out.println("La consultation est mis à jour avec succès !!!");
	}
	
	public void SupprimerConsultation(int id) {
		consultationMapper.supprimerConsultation(id);
		System.out.println("Consultation supprimée avec succès !!!");
	}
	
	public List<Consultation> getPatientId(int patient_id) {
        return consultationMapper.PatientId(patient_id);
    }
	
}
