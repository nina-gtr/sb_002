package dz.ibnrochd.master14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	@Autowired
    private PatientService patientService;
	
	@GetMapping
    public ResponseEntity<List<Patient>> AllPatients() {
        List<Patient> patients = patientService.ListePatients();
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
	
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patientService.CreerPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patientU) {
        Patient patient = patientService.LirePatient(id);
        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        patientU.setId(id); 
        
        patientService.MettreAjourPatient(patientU);
        return ResponseEntity.ok(patientU);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable int id) {
        Patient patient = patientService.LirePatient(id);
        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        patientService.SupprimerPatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
