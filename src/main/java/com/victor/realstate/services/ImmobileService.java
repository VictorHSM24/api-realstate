package com.victor.realstate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.realstate.config.Instantiation;
import com.victor.realstate.domain.Immobile;
import com.victor.realstate.repository.ImmobileRepository;
import com.victor.realstate.repository.ImmobileRepositoryMemory;

@Service
public class ImmobileService {
	
	@Autowired
	private ImmobileRepository imbRepo;
	
	public ImmobileService(ImmobileRepository imbRepo) {
		this.imbRepo = imbRepo;
	}
	
	public List<Immobile> findAll() {
		return imbRepo.findAll();
	}
	
	public Immobile findById(Long id) {
		return imbRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Imobile not found"));
	}
	
	public Immobile insert(Immobile imb) {
		return imbRepo.save(imb);
	}
	
	public Immobile update(Long id, Immobile newImb) {
		Immobile imb = findById(id);
		imb.setName(newImb.getName());
		imb.setDescription(newImb.getDescription());
		imb.setRentPrice(newImb.getRentPrice());
		imb.setAddress(newImb.getAddress());
		return imbRepo.save(imb);
	}
	
	public void delete(Long id) {
		Immobile imb = findById(id);
		imbRepo.delete(imb);
	}
}