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
}
