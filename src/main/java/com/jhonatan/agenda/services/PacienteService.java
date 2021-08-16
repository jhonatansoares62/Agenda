package com.jhonatan.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jhonatan.agenda.exceptions.exception.DataIntegrityException;
import com.jhonatan.agenda.exceptions.exception.ResourceNotFoundExeption;
import com.jhonatan.agenda.model.Paciente;
import com.jhonatan.agenda.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;

	public Paciente findById(Long id) {
		Optional<Paciente> obj = repository.findById(id);
		if (!obj.isPresent()) {
			throw new ResourceNotFoundExeption(id, Paciente.class);
		}
		return obj.get();
	}

	public List<Paciente> findAlll() {
		List<Paciente> objts = repository.findAll();
		return objts;
	}

	public Paciente save(Paciente obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Paciente update(Paciente obj, Long id) {
		Paciente con = repository.findById(id).get();
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possivel excluir um Paciente com uma ou mais consultas associadas.");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeption(id, Paciente.class);
		}
	}

}
