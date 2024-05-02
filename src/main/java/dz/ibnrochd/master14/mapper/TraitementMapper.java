package dz.ibnrochd.master14.mapper;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.Traitement;

@Mapper
public interface TraitementMapper {

	void creerTraitement( Traitement traitement );
	Traitement lireTraitement(int id);
	void mettreAjourTraitement( Traitement traitement );
	void supprimerTraitement( int id );
	
}
