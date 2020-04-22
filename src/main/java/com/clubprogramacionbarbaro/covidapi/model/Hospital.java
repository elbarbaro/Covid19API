package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "hospital")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hospitalId;
	private String nombre;
	private Double latitud;
	private Double longitud;
	private String tipoInstitucion;
	private String domicilio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
}
