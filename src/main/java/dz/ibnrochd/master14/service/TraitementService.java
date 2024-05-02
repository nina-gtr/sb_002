package dz.ibnrochd.master14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.TraitementMapper;
import dz.ibnrochd.master14.model.Traitement;

@Service
public class TraitementService {
	private final TraitementMapper traitementMapper;
	
	@Autowired
    public TraitementService(TraitementMapper traitementMapper) {
        this.traitementMapper = traitementMapper;
    }
	
	public void CreerTraitement(Traitement traitement) {
		traitementMapper.creerTraitement(traitement);
        System.out.println("Traitement ajouté avec succès !!!");
	}
	
	public Traitement LireTraitement(int id) {
		return traitementMapper.lireTraitement(id);
	}
	
	public void MettreAjourTraitement(Traitement traitement) {
		traitementMapper.mettreAjourTraitement(traitement);
		System.out.println("Le traitement est mis à jour avec succès !!!");
	}
	
	public void SupprimerTraitement(int id) {
		traitementMapper.supprimerTraitement(id);
		System.out.println("Traitement supprimé avec succès !!!");
	}
	
}
