package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.LigneConsultationMapper;
import dz.ibnrochd.master14.model.LigneConsultation;

@Service
public class LigneConsultationService {
	private final LigneConsultationMapper ligneConsultationMapper;

    @Autowired
    public LigneConsultationService(LigneConsultationMapper ligneConsultationMapper) {
        this.ligneConsultationMapper = ligneConsultationMapper;
    }

    public List<LigneConsultation> getLigneConsultations() {
    	List<LigneConsultation> ligneConsultations = ligneConsultationMapper.selectAllLigneConsultation();

        for (LigneConsultation ligneConsultation : ligneConsultations) {
            System.out.println("Ligne consultation N°: " + ligneConsultation.getId()+ 
            		"\n	Posologie: " + ligneConsultation.getPosologie()+
            		"\n	Unité de temps: " + ligneConsultation.getUnite_temps() +
            		"\n	Quantité: " + ligneConsultation.getQuantite());
            if (ligneConsultation.getTraitement() != null) {
                System.out.println("	Nom du médicament: " + ligneConsultation.getTraitement().getNom());
            } else {
                System.out.println("Aucun traitement associé");
            }
            System.out.println("---------------------------------------------");
        }
        return ligneConsultations;
    }
}
