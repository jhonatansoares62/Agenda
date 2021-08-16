package com.jhonatan.agenda.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhonatan.agenda.model.Consulta;
import com.jhonatan.agenda.model.Medico;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	List<Consulta> findByData(LocalDate data);

	List<Consulta> findByMedico(Medico medico);

	List<Consulta> findByMedicoNomeLike(String medicoNome);

	List<Consulta> findByOrderByDataAsc();

}
