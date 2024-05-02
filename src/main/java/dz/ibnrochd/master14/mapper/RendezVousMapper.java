package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.RendezVous;

@Mapper
public interface RendezVousMapper {
	
	void creerRendezVous( RendezVous rendezVous );
	RendezVous lireRendezVous(int id);
	void mettreAjourRendezVous( RendezVous rendezVous );
	void supprimerRendezVous( int id );
	
	List<RendezVous> selectAllRendezVous();
	List<RendezVous> PatientId(int patient_id);
}
