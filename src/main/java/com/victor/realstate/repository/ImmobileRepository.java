package com.victor.realstate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.victor.realstate.domain.Immobile;

@Repository
public interface ImmobileRepository {
	Immobile save(Immobile imb);
	Optional<Immobile> findById(Long id);
	List<Immobile> findAll();
	void delete(Immobile imb);
}