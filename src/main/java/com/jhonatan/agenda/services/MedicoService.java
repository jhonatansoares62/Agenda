package com.jhonatan.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jhonatan.agenda.exceptions.exception.DataIntegrityException;
import com.jhonatan.agenda.exceptions.exception.ResourceNotFoundExeption;
import com.jhonatan.agenda.model.Medico;
import com.jhonatan.agenda.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public Medico findById(Long id) {
		Optional<Medico> obj = repository.findById(id);
		if (!obj.isPresent()) {
			throw new ResourceNotFoundExeption(id, Medico.class);
		}
		return obj.get();
	}

	public List<Medico> findAlll() {
		List<Medico> objts = repository.findAll();
		return objts;
	}

	public Medico save(Medico obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Medico update(Medico obj, Long id) {
		Medico con = repository.findById(id).get();
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Medico com uma ou mais consultas associadas.");
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeption(id, Medico.class);
		}
	}
	
	public Medico findByNome(String nome) {
		return repository.findByNomeLike(nome);
	}
}
