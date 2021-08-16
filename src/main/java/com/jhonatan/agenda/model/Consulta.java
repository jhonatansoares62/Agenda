package com.jhonatan.agenda.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	private Medico medico;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Paciente paciente;

	@NotNull
	@ManyToOne
	private Consultorio consultorio;

	@DateTimeFormat(pattern = "yyy-MM-dd")
	private LocalDate data;

	@DateTimeFormat(pattern = "HH:MM")
	private LocalTime hora;

	public Consulta() {

	}

	public Consulta(Long id, Medico medico, Paciente paciente, Consultorio consultorio, LocalDate data,
			LocalTime hora) {
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.consultorio = consultorio;
		this.data = data;
		this.hora = hora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(id, other.id);
	}

}
