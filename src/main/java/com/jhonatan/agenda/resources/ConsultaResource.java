package com.jhonatan.agenda.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhonatan.agenda.dto.consulta.ConsultaDto;
import com.jhonatan.agenda.dto.consulta.NovaConsultaDto;
import com.jhonatan.agenda.model.Consulta;
import com.jhonatan.agenda.services.ConsultaService;

@RestController
@RequestMapping("/resource/consultas")
public class ConsultaResource {

	@Autowired
	private ConsultaService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Consulta> findById(@PathVariable Long id) {

		Consulta obj = service.findById(id);

		return ResponseEntity.ok(obj);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/dto{id}")
	public ResponseEntity<ConsultaDto> findByIdDto(@PathVariable Long id) {

		Consulta obj = service.findById(id);

		return ResponseEntity.ok(new ConsultaDto(obj));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/dto")
	public ResponseEntity<List<ConsultaDto>> findDto() {

		List<ConsultaDto> objts = service.findAll().stream().map(c -> new ConsultaDto(c)).collect(Collectors.toList());

		return ResponseEntity.ok(objts);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/dto/medico{id}")
	public ResponseEntity<List<ConsultaDto>> findDtoByMedico(@PathVariable Long id) {

		List<ConsultaDto> objts = service.findByMedico(id).stream().map(c -> new ConsultaDto(c)).collect(Collectors.toList());

		return ResponseEntity.ok(objts);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<Consulta>> find() {

		List<Consulta> objts = service.findAll();

		return ResponseEntity.ok(objts);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	@PostMapping
	public ResponseEntity<ConsultaDto> save(@Valid @RequestBody NovaConsultaDto obj) {
		Consulta c = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Consulta obj, @PathVariable Long id) {
		obj.setId(id);
		obj = service.update(obj, id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
