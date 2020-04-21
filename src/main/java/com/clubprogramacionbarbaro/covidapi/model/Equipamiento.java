package com.clubprogramacionbarbaro.covidapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Equipamiento {

	private Integer equipamientoId;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private LocalDate fechaVencimiento;
	private LocalDateTime fechaCreacion;
}
