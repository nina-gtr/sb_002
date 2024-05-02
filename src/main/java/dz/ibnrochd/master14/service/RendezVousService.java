package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.RendezVousMapper;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.RendezVous;

@Service
public class RendezVousService {
	private final RendezVousMapper rendezVousMapper;
	
	@Autowired
    public RendezVousService(RendezVousMapper rendezVousMapper) {
        this.rendezVousMapper = rendezVousMapper;
    }

    public void AllRendezVous() {
        List<RendezVous> rdvs = rendezVousMapper.selectAllRendezVous();
        for (RendezVous rdv : rdvs) {
            System.out.println(rdv);
        }
    }
    
    public void CreerRendezVous(RendezVous rendezVous) {
    	rendezVousMapper.creerRendezVous(rendezVous);
        System.out.println("Rendez-Vous ajouté avec succès !!!");
	}
	
	public RendezVous LireRendezVous(int id) {
		return rendezVousMapper.lireRendezVous(id);
	}
	
	public void MettreAjourRendezVous(RendezVous rendezVous) {
		rendezVousMapper.mettreAjourRendezVous(rendezVous);
		System.out.println("Rendez-Vous est mis à jour avec succès !!!");
	}
	
	public void SupprimerRendezVous(int id) {
		rendezVousMapper.supprimerRendezVous(id);
		System.out.println("Rendez-Vous supprimé avec succès !!!");
	}
	
	public List<RendezVous> getPatientId(int patient_id) {
        return rendezVousMapper.PatientId(patient_id);
    }
}
