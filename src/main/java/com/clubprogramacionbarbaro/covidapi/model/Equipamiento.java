package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class Equipamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer equipamientoId;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	@Temporal(TemporalType.DATE)
	private java.sql.Date fechaVencimiento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
}
