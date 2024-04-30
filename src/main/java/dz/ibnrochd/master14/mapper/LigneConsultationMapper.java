package dz.ibnrochd.master14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dz.ibnrochd.master14.model.LigneConsultation;

@Mapper
public interface LigneConsultationMapper {
	List<LigneConsultation> selectAllLigneConsultation();
}
