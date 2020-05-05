package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "domicilio")
public class Domicilio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer domicilioId;
	@Column(length = 30)
	private String calle;
	@Column(length = 10)
	private String numeroInterior;
	@Column(length = 10)
	private String numeroExterior;
	@Column(length = 10)
	private String codigoPostal;
	@Column(length = 30)
	private String colonia;
	@Column(length = 30)
	private String municipio;
	@Column(length = 20)
	private String estado;
	@Column(length = 20)
	private String pais;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@OneToOne
	@JoinColumn(name = "enlaceId", referencedColumnName = "enlaceId")
	private Enlace enlace;
}
