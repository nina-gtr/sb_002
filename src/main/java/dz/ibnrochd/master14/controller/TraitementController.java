package dz.ibnrochd.master14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.Traitement;
import dz.ibnrochd.master14.service.TraitementService;

@RestController
@RequestMapping("/api/traitements")
public class TraitementController {
	@Autowired
    private TraitementService traitementService;
	
	@GetMapping
    public ResponseEntity<List<Traitement>> AllTraitements() {
        List<Traitement> traitements = traitementService.ListeTraitements();
        if (traitements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(traitements, HttpStatus.OK);
    }
}
