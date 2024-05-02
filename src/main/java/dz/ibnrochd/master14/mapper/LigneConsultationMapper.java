package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation;

@Mapper
public interface LigneConsultationMapper {
	
	void creerLigneConsultation( LigneConsultation ligneConsultation );
	LigneConsultation lireLigneConsultation(int id);
	void mettreAjourLigneConsultation( LigneConsultation ligneConsultation );
	void supprimerLigneConsultation( int id );
	
	List<LigneConsultation> selectAllLigneConsultation();
	
	List<LigneConsultation> ConsultationId(int consult_id);
	List<LigneConsultation> TraitementId(int trait_id);
}
