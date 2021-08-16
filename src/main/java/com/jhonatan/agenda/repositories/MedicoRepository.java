package com.jhonatan.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhonatan.agenda.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
	Medico findByNomeLike(String nome);

}
