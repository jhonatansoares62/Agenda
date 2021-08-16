package com.jhonatan.agenda.dto.consulta;

import java.io.Serializable;

public class NovaConsultaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long pacienteId;
	private Long medicoId;
	private String hora;
	private String data;
	private Long consultorioId;

	public NovaConsultaDto() {

	}

	public NovaConsultaDto(Long pacienteId, Long medicoId, String hora, String data, Long consultorioId) {
		super();
		this.pacienteId = pacienteId;
		this.medicoId = medicoId;
		this.hora = hora;
		this.data = data;
		this.consultorioId = consultorioId;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
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

	

}
