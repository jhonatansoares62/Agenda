package com.jhonatan.agenda.dto.save;

import java.io.Serializable;

public class ConsultaInsertDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long pacienteID;
	private String especialidadeMedica;
	private Long medicoId;
	private String hora;
	private String data;
	private Long consultorioId;

	public ConsultaInsertDto() {

	}

	public ConsultaInsertDto(Long id, Long pacienteID, String especialidadeMedica, Long medicoId, String hora, String data,
			Long consultorioId) {
		super();
		this.id = id;
		this.pacienteID = pacienteID;
		this.especialidadeMedica = especialidadeMedica;
		this.medicoId = medicoId;
		this.hora = hora;
		this.data = data;
		this.consultorioId = consultorioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPacienteID() {
		return pacienteID;
	}

	public void setPacienteID(Long pacienteID) {
		this.pacienteID = pacienteID;
	}

	public String getEspecialidadeMedica() {
		return especialidadeMedica;
	}

	public void setEspecialidadeMedica(String especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}

	public Long getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getConsultorioId() {
		return consultorioId;
	}

	public void setConsultorioId(Long consultorioId) {
		this.consultorioId = consultorioId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
