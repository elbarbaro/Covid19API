package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	
	@OneToMany(targetEntity = Equipamiento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId")
	private List<Equipamiento> equipamientos;
	
	@ManyToMany(mappedBy = "hospitales")
	private List<Enlace> enlaces;
}
