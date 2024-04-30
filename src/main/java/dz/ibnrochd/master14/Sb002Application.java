package dz.ibnrochd.master14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.service.PatientService;
import dz.ibnrochd.master14.service.ConsultationService;
import dz.ibnrochd.master14.service.LigneConsultationService;

@SpringBootApplication
public class Sb002Application implements CommandLineRunner {
	
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	// TODO : déclarer les autres repository de la même façon que PatientRepository
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private LigneConsultationService ligneConsultationService;

	public static void main(String[] args) {
		SpringApplication.run(Sb002Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO : récupérer la liste de tous les patients puis afficher leurs noms
		patientService.ListePatients();
		
		// TODO : rechercher les patients ayant le nom "Yahi" puis leurs prénoms
		patientService.RechercherParNom("Yahi");
		
		
		// TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
		
		Patient newPatient = new Patient();
		newPatient.setNom("GATER");
		newPatient.setPrenom("Thanina");
        newPatient.setSexe ("F");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
         Date dateNaiss = dateFormat.parse("1999-05-15");
         newPatient.setDateNaissance(dateNaiss);
        } catch (ParseException e) {
         e.printStackTrace();
        }
        newPatient.setNumeroTelephone ("0552369855");
        newPatient.setAdresse ("CNTSID");

        patientService.NewPatient(newPatient);
        
        

				
		// TODO : rechercher la consultation ayant id=3 
        consultationService.RechercherParId(3);

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
        ligneConsultationService.getLigneConsultations();

        
		
	}

}
