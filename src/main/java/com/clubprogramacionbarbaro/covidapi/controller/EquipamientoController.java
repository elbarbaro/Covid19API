package com.clubprogramacionbarbaro.covidapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;
import com.clubprogramacionbarbaro.covidapi.model.Hospital;
import com.clubprogramacionbarbaro.covidapi.service.EquipamientoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/${api.version}/equipamientos")
@AllArgsConstructor
public class EquipamientoController {
	
	private EquipamientoService equipamientoService;
	
	@GetMapping
	public ResponseEntity<List<Equipamiento>> findAllEquipamiento() {
		return new ResponseEntity<>(equipamientoService.findAllEquipamiento(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Equipamiento> saveEquipamiento(@RequestBody Equipamiento equipamiento) {
		return new ResponseEntity<>(equipamientoService.saveEquipamiento(equipamiento), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}/hospitales")
	public ResponseEntity<Equipamiento> addHospitalToEquipamiento(
			@PathVariable("id") Integer equipamientoId, @RequestBody Hospital hospital) {
		return new ResponseEntity<>(equipamientoService.addHospitalToEquipamiento(equipamientoId, hospital.getHospitalId()), HttpStatus.OK);
	}
}
