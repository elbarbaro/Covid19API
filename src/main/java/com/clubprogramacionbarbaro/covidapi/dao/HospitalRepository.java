package com.clubprogramacionbarbaro.covidapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubprogramacionbarbaro.covidapi.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	List<Hospital> findByNombre(String nombre);
}