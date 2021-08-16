package com.jhonatan.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jhonatan.agenda.exceptions.exception.DataIntegrityException;
import com.jhonatan.agenda.exceptions.exception.ResourceNotFoundExeption;
import com.jhonatan.agenda.model.Consultorio;
import com.jhonatan.agenda.repositories.ConsultorioRepository;

@Service
public class ConsultorioService {

	@Autowired
	private ConsultorioRepository repository;

	public Consultorio findById(Long id) {
		Optional<Consultorio> obj = repository.findById(id);
		if (!obj.isPresent()) {
			throw new ResourceNotFoundExeption( id, Consultorio.class);
		}
		return obj.get();
	}

	public List<Consultorio> findAlll() {
		List<Consultorio> objts = repository.findAll();
		return objts;
	}

	public Consultorio save(Consultorio obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Consultorio update(Consultorio obj, Long id) {
		Consultorio con = repository.findById(id).get();
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possivel excluir um Consultorio com uma ou mais consultas associadas.");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeption(id, Consultorio.class);
		}
	}

}
