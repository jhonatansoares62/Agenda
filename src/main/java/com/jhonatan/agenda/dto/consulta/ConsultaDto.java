package com.jhonatan.agenda.dto.consulta;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.jhonatan.agenda.model.Consulta;
import com.jhonatan.agenda.model.emums.EspecialidadeMedica;

public class ConsultaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String pacienteNome;
	private EspecialidadeMedica especialidadeMedica;
	private String medicoNome;
	private String medicoCRM;
	private String hora;
	private String data;
	private int consultorioNumero;

	public ConsultaDto() {

	}

	public ConsultaDto(Consulta consulta) {
		this.id = consulta.getId();
		this.pacienteNome = consulta.getPaciente().getNome();
		this.especialidadeMedica = consulta.getMedico().getEspecialidade();
		this.medicoNome = consulta.getMedico().getNome();
		this.medicoCRM = consulta.getMedico().getCRM();
		DateTimeFormatter fD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter fH = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.hora = consulta.getHora().format(fH);
		this.data = consulta.getData().format(fD);
		this.consultorioNumero = consulta.getConsultorio().getNumero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPacienteNome() {
		return pacienteNome;
	}

	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}

	public EspecialidadeMedica getEspecialidadeMedica() {
		return especialidadeMedica;
	}

	public void setEspecialidadeMedica(EspecialidadeMedica especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}

	public String getMedicoNome() {
		return medicoNome;
	}

	public void setMedicoNome(String medicoNome) {
		this.medicoNome = medicoNome;
	}

	public String getMedicoCRM() {
		return medicoCRM;
	}

	public void setMedicoCRM(String medicoCRM) {
		this.medicoCRM = medicoCRM;
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

	public int getConsultorioNumero() {
		return consultorioNumero;
	}

	public void setConsultorioNumero(int consultorioNumero) {
		this.consultorioNumero = consultorioNumero;
	}

}
