package com.jhonatan.agenda.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jhonatan.agenda.dto.consulta.NovaConsultaDto;
import com.jhonatan.agenda.exceptions.exception.DataIntegrityException;
import com.jhonatan.agenda.exceptions.exception.ResourceNotFoundExeption;
import com.jhonatan.agenda.model.Consulta;
import com.jhonatan.agenda.model.Consultorio;
import com.jhonatan.agenda.model.Medico;
import com.jhonatan.agenda.model.Paciente;
import com.jhonatan.agenda.model.emums.EspecialidadeMedica;
import com.jhonatan.agenda.repositories.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private ConsultorioService consultorioService;

	@Autowired
	private PacienteService pacienteService;

	public Consulta findById(Long id) {
		Optional<Consulta> obj = repository.findById(id);
		if (!obj.isPresent()) {
			throw new ResourceNotFoundExeption(id, Paciente.class);
		}
		return obj.get();
	}

	public List<Consulta> findAll() {
		List<Consulta> objts = repository.findByOrderByDataAsc();
		return objts;
	}

	public Consulta update(Consulta obj, Long id) {
		repository.findById(id).get();
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possivel excluir uma consulta que se relaciona com medico, paciente ou consultorio.");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeption(id, Consulta.class);
		}
	}

	public List<Consulta> findByDate(LocalDate data) {
		return repository.findByData(data);
	}

	public List<Consulta> findByMedico(Long id) {
		Medico medico = medicoService.findById(id);
		return repository.findByMedico(medico);
	}

	public List<Consulta> findByMedicoNome(String medicoNome) {
		return repository.findByMedicoNomeLike(medicoNome);
	}

	public @Valid Consulta save(@Valid NovaConsultaDto obj) {

		System.out.println("Objeto recebido: " + obj.getConsultorioId());
		System.out.println("Objeto recebido: " + obj.getMedicoId());
		System.out.println("Objeto recebido: " + obj.getConsultorioId());
		System.out.println("Objeto recebido: " + obj.getData());
		System.out.println("Objeto recebido: " + obj.getHora());
		System.out.println("Substring: " + obj.getData().substring(0, 10));

		LocalDate data = formatarData(obj.getData());
		LocalTime hora = formatarHora(obj.getHora());

		List<Consulta> consultasDoDia = findByDate(data);

		dataValilda(data);
		validarQuantidade(data, consultasDoDia);
		validarConsultasPorPaciente(obj.getPacienteId(), consultasDoDia);
		Medico m = medicoService.findById(obj.getMedicoId());
		validarMedico(m, consultasDoDia);
		validarHorario(hora, data);

		Paciente p = pacienteService.findById(obj.getPacienteId());

		Consultorio c = consultorioService.findById(obj.getConsultorioId());
		Consulta consulta = new Consulta();
		consulta.setConsultorio(c);
		consulta.setMedico(m);
		consulta.setPaciente(p);

		consulta.setData(data);
		consulta.setHora(hora);
		return repository.save(consulta);

	}

	private void validarMedico(Medico medico, List<Consulta> consultas) {
		if (!consultas.isEmpty()) {
			
			for(Consulta c : consultas) {
				if(c.getMedico().getId() != medico.getId()) {
					throw new DataIntegrityException(
							"Nao é possivel cadastrar para medicos diferentes no dia em um consultorio !");
				}
			}
			
			if (consultas.get(0).getId() != medico.getId()) {
				if (consultas.get(0).getMedico().getEspecialidade().equals(EspecialidadeMedica.CIRURGIA_GERAL)) {
					Long id = consultas.get(0).getMedico().getId();
					for (Consulta c : consultas) {
						if (c.getId() != id) {
							throw new DataIntegrityException(
									"Nao é possivel cadastrar para medicos diferentes no dia em um consultorio !");
						}
					}
				}
			}
		}
	}

	private void dataValilda(LocalDate data) {
		LocalDate agora = LocalDate.now();
		if (data.isBefore(agora)) {
			throw new DataIntegrityException("Nao é possivel cadastrar mais de uma consulta para uma data no passado!");
		}
	}

	private void validarConsultasPorPaciente(Long pacienteId, List<Consulta> consultas) {
		for (Consulta c : consultas) {
			if (c.getPaciente().equals(pacienteId)) {
				throw new DataIntegrityException(
						"Nao é possivel cadastrar mais de uma consulta para uma pessoa no mesmo dia!");
			}
		}
	}

	private void validarQuantidade(LocalDate data, List<Consulta> consultas) {

		if (consultas.size() >= 12) {

			throw new DataIntegrityException(
					"Nao é possivel cadastrar mais de 12 consultas no mes mo dia em um escritorio!");
		}
	}

	void validarHorario(LocalTime hora, LocalDate data) {
		List<Consulta> consultas = findByDate(data);

		int hora2 = hora.getHour() * 60 + hora.getMinute();
		
		for (Consulta c : consultas) {
			LocalTime h = c.getHora();
			
			int hora1 = h.getHour() * 60 + h.getMinute();

			if (hora1 - hora2 >= 15) {
				throw new DataIntegrityException("Limite de 15 minutos entre consultas!");
			}
		}
	}

	private LocalDate formatarData(String data) {
		DateTimeFormatter dataformater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate d = LocalDate.parse(data.substring(0, 10), dataformater);
		return d;
	}

	private LocalTime formatarHora(String hora) {
		DateTimeFormatter horaFormater = DateTimeFormatter.ofPattern("HH:MM");
		LocalTime h = LocalTime.parse(hora, horaFormater);
		return h;
	}

}
