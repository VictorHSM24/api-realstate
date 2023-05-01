package com.victor.realstate.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.victor.realstate.domain.Immobile;

@Component
public class ImmobileRepositoryMemory implements ImmobileRepository {
	private Map<Long, Immobile> imbRepo = new HashMap<>();
	private Long nextId = 1L;

	@Override
	public Immobile save(Immobile imb) {
		if (imb.getId() == null) {
			imb.setId(nextId++);
		}
		imbRepo.put(imb.getId(), imb);
		return null;
	}

	@Override
	public Optional<Immobile> findById(Long id) {
		return Optional.ofNullable(imbRepo.get(id));
	}

	@Override
	public List<Immobile> findAll() {
		return new ArrayList<>(imbRepo.values());
	}

	@Override
	public void delete(Immobile imb) {
		imbRepo.remove(imb.getId());
	}
}