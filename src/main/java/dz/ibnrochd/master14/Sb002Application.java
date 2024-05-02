package dz.ibnrochd.master14;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import dz.ibnrochd.master14.mapper.PatientMapper;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.RendezVous;
import dz.ibnrochd.master14.model.Traitement;
import dz.ibnrochd.master14.service.PatientService;
import dz.ibnrochd.master14.service.RendezVousService;
import dz.ibnrochd.master14.service.TraitementService;
import dz.ibnrochd.master14.service.ConsultationService;
import dz.ibnrochd.master14.service.LigneConsultationService;

@SpringBootApplication
public class Sb002Application implements CommandLineRunner {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	// TODO : déclarer les autres repository de la même façon que PatientRepository
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private LigneConsultationService ligneConsultationService;
	@Autowired
	private RendezVousService rendezVousService;
	@Autowired
	private TraitementService traitementService;

	public static void main(String[] args) {
		SpringApplication.run(Sb002Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* 
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

        patientService.CreerPatient(newPatient);
        
        

				
		// TODO : rechercher la consultation ayant id=3 
        consultationService.RechercherParId(3);

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
        ligneConsultationService.getLigneConsultations();
        */
        
		
		// TODO Consultation
		// Create
		Consultation consultation = new Consultation();
		consultation.setMotif("Visite");
        long timestampInMillis = System.currentTimeMillis();
        Date date = new Date(timestampInMillis);
        Timestamp dateconsult = new Timestamp(date.getTime());
        consultation.setDateConsult(dateconsult);
        Patient patient = new Patient();
        patient.setId(1);
        consultation.setPatient(patient);
        consultationService.CreerConsultation(consultation);
        // Read
        Consultation consultR = consultationService.LireConsultation(3);
        if(consultR != null) {
        	System.out.println("Consultation { "+ consultR.getId()+ ", "+consultR.getMotif()+ ", "+consultR.getDateConsult()+ "} ");
        }
        else {
        	System.out.println("Aucune consultation trouvé");
        }
        // Update
        Consultation consult = consultationService.LireConsultation(10);
        if(consult != null) {
        	consult.setMotif("Visite médicale");
        	patient.setId(1);
        	consult.setPatient(patient);
        	consult.setDateConsult(dateconsult);
        	consultationService.MettreAjourConsultation(consult);
        }
        else {
        	System.out.println("Aucune consultation trouvé");
        }
        // Delete
        Consultation consultSupp = consultationService.LireConsultation(3);
        if(consultSupp != null) {
	          List<LigneConsultation> ls = ligneConsultationService.getConsultationId(3);
	      	  if (!ls.isEmpty()) {
	      	    System.out.println("Suppression impossible pour cette consultation !!!");
	  	      } 
	  	      else {
	  	    	consultationService.SupprimerConsultation(3);
	  	      }
        	
        }
        else {
        	System.out.println("Cette consultation n'existe pas");
        }
		
        
     // TODO Ligne Consultation
     // Create
     LigneConsultation ligneconsultation = new LigneConsultation();
     ligneconsultation.setPosologie("2x /jour");
 	 Consultation consult_Ligne = new Consultation();
 	 consult_Ligne.setId(1);
 	 ligneconsultation.setConsultation(consult_Ligne);
 	 Traitement traitement_Ligne = new Traitement();
 	 traitement_Ligne.setId(1);
 	 ligneconsultation.setTraitement(traitement_Ligne);
     ligneconsultation.setUnite_temps("7 jours");;
 	 ligneconsultation.setQuantite("1");
     ligneConsultationService.CreerLigneConsultation(ligneconsultation);
     // Read
     LigneConsultation ligneconsultR = ligneConsultationService.LireLigneConsultation(3);
     if(ligneconsultR != null) {
    	 System.out.println("Ligne Consultation { "+ ligneconsultR.getId()+ ", "+ligneconsultR.getPosologie()+ ", "+ligneconsultR.getUnite_temps()+ ", "+ligneconsultR.getQuantite()+ "} ");
     }
     else {
    	 System.out.println("Aucune ligne consultation trouvé");
     }
     // Update
     LigneConsultation ligneconsult = ligneConsultationService.LireLigneConsultation(7);
     if(ligneconsult != null) {
    	 ligneconsult.setPosologie("2x /jour");
    	 consult_Ligne.setId(1);
    	 ligneconsult.setConsultation(consult_Ligne);
    	 traitement_Ligne.setId(1);
    	 ligneconsult.setTraitement(traitement_Ligne);
    	 ligneconsult.setUnite_temps("15 jours");;
    	 ligneconsult.setQuantite("1");
    	 ligneConsultationService.MettreAjourLigneConsultation(ligneconsult);
      }
      else {
      System.out.println("Aucune ligne consultation trouvé");
      }
      // Delete
     LigneConsultation ligneconsultSupp = ligneConsultationService.LireLigneConsultation(8);
     if(ligneconsultSupp != null) {
         ligneConsultationService.SupprimerLigneConsultation(8);
     } 
     else {
         System.out.println("Cette ligne consultation n'existe pas !!!");
     }
     
     
  // TODO Patient
  // Create
     Patient newPatient = new Patient();
     newPatient.setNom("GATER");
     newPatient.setPrenom("Thanina");
     newPatient.setSexe ("F");
     
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     try {
        Date dateNaiss = dateFormat.parse("2000-05-15");
        newPatient.setDateNaissance(dateNaiss);
     } catch (ParseException e) {
      e.printStackTrace();
     }
     newPatient.setNumeroTelephone ("0552369855");
     newPatient.setAdresse ("CNTSID");

     patientService.CreerPatient(newPatient);
     // Read
 	 Patient patientR = patientService.LirePatient(3);
     if(patientR != null) {
     	System.out.println("Patient { "+ patientR.getId()+ ", "+patientR.getNom()+ ", "+patientR.getPrenom()+ ", "+patientR.getSexe()+ ", "+patientR.getDateNaissance()+ ", "+patientR.getNumeroTelephone()+ ", "+patientR.getAdresse()+ "} ");
     }
     else {
    	    System.out.println("Aucun patient trouvé");
     }
     
     // Update
     Patient patientU = patientService.LirePatient(42);
     if(patientU != null) {
    	 patientU.setNom("GATER");
    	 patientU.setPrenom("Thanina");
    	 patientU.setSexe ("F");
         SimpleDateFormat dateFormatU = new SimpleDateFormat("yyyy-MM-dd");
         try {
            Date dateNaissU = dateFormatU.parse("2001-05-15");
            patientU.setDateNaissance(dateNaissU);
         } catch (ParseException e) {
          e.printStackTrace();
         }
         patientU.setNumeroTelephone ("0552369855");
         patientU.setAdresse ("Douane");
    	 
    	 patientService.MettreAjourPatient(patientU);
      }
      else {
    	  System.out.println("Aucun patient trouvé");
      }
      // Delete
     Patient patientD = patientService.LirePatient(2);
      if(patientD != null) {
    	  List<Consultation> consultations = consultationService.getPatientId(2);
    	  List<RendezVous> rdv = rendezVousService.getPatientId(2);
    	  if (!consultations.isEmpty() || !rdv.isEmpty()) {
    	    System.out.println("Suppression impossible pour ce patient!!!");
	      } 
	      else {
	    	    patientService.SupprimerPatient(2);
	      }
      } 
      else {
         System.out.println("Le patient n'existe pas !!!");
      }
      
      
     
   // TODO Rendez-Vous
   // Create
   RendezVous rendezVous = new RendezVous();
   long MillisR = System.currentTimeMillis();
   Date dateR = new Date(MillisR);
   Timestamp dateRV = new Timestamp(dateR.getTime());
   rendezVous.setDateRdv(dateRV);
   Patient patientRV = new Patient();
   patientRV.setId(1);
   rendezVous.setPatient(patientRV);
   rendezVousService.CreerRendezVous(rendezVous);
   // Read
    RendezVous rendezVousR = rendezVousService.LireRendezVous(3);
   if(rendezVousR != null) {
	   System.out.println("Rendez-Vous { "+ rendezVousR.getId()+ ", "+rendezVousR.getDateRdv()+ "} ");
   }
   else {
  	 System.out.println("Aucun Rendez-Vous trouvé");
   }
   // Update
   RendezVous rendezVousU = rendezVousService.LireRendezVous(6);
   if(rendezVousU != null) {
	   long MillisRU = System.currentTimeMillis();
	   Date dateRU = new Date(MillisRU);
	   Timestamp dateRVU = new Timestamp(dateRU.getTime());
	   rendezVousU.setDateRdv(dateRVU);
	   Patient patientRVU = new Patient();
	   patientRVU.setId(2);
	   rendezVousU.setPatient(patientRVU);
  	   rendezVousService.MettreAjourRendezVous(rendezVousU);
   }
   else {
	   System.out.println("Aucun Rendez-Vous trouvé");
   }
    // Delete
   RendezVous rendezVousD = rendezVousService.LireRendezVous(5);
   if(rendezVousD != null) {
	   rendezVousService.SupprimerRendezVous(5);
   } 
   else {
       System.out.println("Ce rendez-vous n'existe pas !!!");
   }  
     
   // TODO Rendez-Vous
   // Create
   Traitement traitement = new Traitement();
   traitement.setNom("Doliprane");  
   traitementService.CreerTraitement(traitement);  
   // Read
   Traitement traitementR = traitementService.LireTraitement(3);
   if(traitementR != null) {
	   System.out.println("Traitement { "+ traitementR.getId()+ ", "+traitementR.getNom()+ "} ");
   }
   else {
 	 System.out.println("Aucun traitement trouvé");
   }  
   // Update
   Traitement traitementU = traitementService.LireTraitement(100);
   if(traitementU != null) { 
	   traitementU.setNom("Doliprane 1000");  
	   traitementService.MettreAjourTraitement(traitementU); 
   }
   else {
 	 System.out.println("Aucun traitement trouvé");
   }   
   // Delete
   Traitement traitementD = traitementService.LireTraitement(68);
   if(traitementD != null) {
	   List<LigneConsultation> ls = ligneConsultationService.getTraitementId(68);
   	   if (!ls.isEmpty()) {
   	    System.out.println("Suppression impossible pour ce traitement !!!");
	      } 
	      else {
	    	  traitementService.SupprimerTraitement(68);
	      }
	   
   } 
   else {
       System.out.println("Ce traitement n'existe pas !!!");
   }   
    
     
     
     
	}
	

}
