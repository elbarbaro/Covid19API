package com.clubprogramacionbarbaro.covidapi.service;

import java.util.List;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;

public interface EquipamientoService {
	
	List<Equipamiento> findAllEquipamiento();
	Equipamiento findEquipamientoById(Integer hospitalId);
	Equipamiento saveEquipamiento(Equipamiento hospital);
	Equipamiento updateEquipamiento(Integer hospitalId, Equipamiento hospital);
	Equipamiento addHospitalToEquipamiento(Integer equipamientoId, Integer hospitalId);
	void deleteEquipamientoById(Integer hospitalId);
}
