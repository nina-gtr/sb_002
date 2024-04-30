package dz.ibnrochd.master14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master14.mapper.RendezVousMapper;
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
}
