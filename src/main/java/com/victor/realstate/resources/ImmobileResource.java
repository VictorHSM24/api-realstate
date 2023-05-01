package com.victor.realstate.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.victor.realstate.domain.Immobile;
import com.victor.realstate.services.ImmobileService;

@RestController
@RequestMapping("/immobiles")
public class ImmobileResource {

	@Autowired
	private ImmobileService service;

	@GetMapping
	public ResponseEntity<List<Immobile>> findAll() {
		List<Immobile> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Immobile> findById(@PathVariable Long id) {
		Immobile imb = service.findById(id);
		return ResponseEntity.ok().body(imb);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Immobile reqImb) {
		Immobile imb = new Immobile(null, reqImb.getName(), reqImb.getDescription(), reqImb.getRentPrice(),
				reqImb.getAddress());
		imb = service.insert(imb);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reqImb.getId()).encode()
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Immobile imb, @PathVariable Long id) {
		imb.setId(id);
		service.update(id, imb);
		return ResponseEntity.noContent().build();
	}
}