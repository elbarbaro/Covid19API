package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "equipamiento")
public class Equipamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer equipamientoId;
	// Foreign Key
	private Integer hospitalId;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
}
