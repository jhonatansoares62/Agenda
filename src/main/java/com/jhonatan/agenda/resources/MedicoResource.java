package com.jhonatan.agenda.resources;

import java.net.URI;
import java.util.List;

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

import com.jhonatan.agenda.model.Medico;
import com.jhonatan.agenda.services.MedicoService;

@RestController
@RequestMapping("/resource/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Medico> findById(@PathVariable Long id) {
		Medico obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<Medico>> findAll() {
		List<Medico> objts = service.findAlll();
		return ResponseEntity.ok(objts);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<Medico> save(@Valid @RequestBody Medico obj) {
		obj = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Medico obj, @PathVariable Long id) {
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
