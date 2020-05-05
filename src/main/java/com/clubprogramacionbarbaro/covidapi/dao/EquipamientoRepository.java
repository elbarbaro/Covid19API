package com.clubprogramacionbarbaro.covidapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer>{

}
