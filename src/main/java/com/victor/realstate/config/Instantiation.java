package com.victor.realstate.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.victor.realstate.domain.Immobile;
import com.victor.realstate.repository.ImmobileRepository;

@Component
public class Instantiation implements CommandLineRunner {
	private ImmobileRepository immobileRepository;
	
	public Instantiation(ImmobileRepository immobileRepository) {
		this.immobileRepository = immobileRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		immobileRepository.save(new Immobile(null, "Casa Jd. A", "Casa com 3 quartos", 700.0, "Rua A, Bairro Jardim A"));
		immobileRepository.save(new Immobile(null, "Casa Jd. B", "Casa com 2 quartos", 600.0, "Rua B, Bairro Jardim B"));
		immobileRepository.save(new Immobile(null, "Casa Jd. C", "Casa com 1 quarto", 500.0, "Rua C, Bairro Jardim C"));
	}
}