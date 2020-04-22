package com.clubprogramacionbarbaro.covidapi.service;

import java.util.List;

import com.clubprogramacionbarbaro.covidapi.model.Hospital;

public interface HospitalService {

	List<Hospital> findAllHospital();
	Hospital findHospitalById(Integer hospitalId);
	Hospital saveHospital(Hospital hospital);
	Hospital updateHospital(Integer hospitalId, Hospital hospital);
	void deleteHospitalById(Integer hospitalId);
}
