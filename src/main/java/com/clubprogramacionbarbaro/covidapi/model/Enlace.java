package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "enlace")
public class Enlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enlaceId;
	
	@Column(length = 30)
	private String nombre;
	@Column(length = 30)
	private String apellidos;
	
	@Column(unique = true)
	private String correo;
	
	@Column(length = 15)
	private String telefono;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@OneToOne(mappedBy = "enlace")
	private Domicilio domicilio;
	
	@ManyToMany
	@JoinTable(name = "enlace_hospital", 
	joinColumns = @JoinColumn(name = "enlaceId", referencedColumnName = "enlaceId"),
	inverseJoinColumns = @JoinColumn(name = "hospitalId", referencedColumnName = "hospitalid")
	)
	private List<Hospital> hospitales;
}
