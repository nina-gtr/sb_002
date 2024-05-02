package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Consultation;

@Mapper
public interface ConsultationMapper {
	
	void creerConsultation( Consultation consultation );
	Consultation lireConsultation(int id);
	void mettreAjourConsultation( Consultation consultation );
	void supprimerConsultation( int id );
	
	
	List<Consultation> findConsultationsById(int id);
	
	List<Consultation> PatientId(int patient_id);
}
