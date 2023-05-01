package com.victor.realstate.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.DecimalMin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Immobile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String name;
	private String description;
	@DecimalMin("0.0")
	private Double rentPrice;
	private String address;
	
	public Immobile() {
	}

	public Immobile(Long id, String name, String description, Double rentPrice, String address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rentPrice = rentPrice;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Immobile other = (Immobile) obj;
		return Objects.equals(id, other.id);
	}
}