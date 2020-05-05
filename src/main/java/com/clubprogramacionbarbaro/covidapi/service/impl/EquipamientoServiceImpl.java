package com.clubprogramacionbarbaro.covidapi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clubprogramacionbarbaro.covidapi.dao.EquipamientoRepository;
import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;
import com.clubprogramacionbarbaro.covidapi.service.EquipamientoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipamientoServiceImpl implements EquipamientoService {

	private EquipamientoRepository equipamientoRepository;
	
	@Override
	public List<Equipamiento> findAllEquipamiento() {
		return equipamientoRepository.findAll();
	}

	@Override
	public Equipamiento findEquipamientoById(Integer equipamientoId) {
		return equipamientoRepository.findById(equipamientoId).get();
	}

	@Override
	public Equipamiento saveEquipamiento(Equipamiento equipamiento) {
		equipamiento.setFechaCreacion(new Date());
		return equipamientoRepository.save(equipamiento);
	}

	@Override
	public Equipamiento updateEquipamiento(Integer equipamientoId, Equipamiento equipamiento) {
		
		Equipamiento equipamientoDB = findEquipamientoById(equipamientoId);
		equipamientoDB.setNombre(equipamiento.getNombre());
		equipamientoDB.setCantidad(equipamiento.getCantidad());
		equipamientoDB.setDescripcion(equipamiento.getDescripcion());
		equipamientoDB.setFechaVencimiento(equipamiento.getFechaVencimiento());
		return equipamientoRepository.save(equipamientoDB);
	}

	@Override
	public void deleteEquipamientoById(Integer equipamientoId) {
		equipamientoRepository.deleteById(equipamientoId);
	}

	@Override
	public Equipamiento addHospitalToEquipamiento(Integer equipamientoId, Integer hospitalId) {
		Equipamiento equipamiento = findEquipamientoById(equipamientoId);
		equipamiento.setHospitalId(hospitalId);
		return equipamientoRepository.save(equipamiento);
	}
}
