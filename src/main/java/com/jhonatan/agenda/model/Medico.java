package com.jhonatan.agenda.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jhonatan.agenda.model.emums.EspecialidadeMedica;

@Entity
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 150)
	private String nome;
	
	private LocalDate dataNascimento;
	
	private String CRM;

	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();

	private int especialidade;

	public Medico() {

	}

	public Medico(Long id, String nome, LocalDate dataNascimento, String cRM, EspecialidadeMedica especialidade) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		CRM = cRM;
		this.especialidade = especialidade.getCodigo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public EspecialidadeMedica getEspecialidade() {
		return EspecialidadeMedica.toEnum(especialidade);
	}

	public void setEspecialidade(EspecialidadeMedica especialidade) {
		this.especialidade = especialidade.getCodigo();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(id, other.id);
	}

}
