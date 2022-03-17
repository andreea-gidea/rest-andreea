package com.endava.rest.service;

import com.endava.rest.model.Pet;
import com.endava.rest.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

	private final PetRepository petRepository;

	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public List <Pet> findAll(){
		return petRepository.findAll();
	}

	public Optional<Pet> findById(Long id) {
		return petRepository.findById(id);
	}

	public Optional<Pet> findByStatus(Long id) {
		return petRepository.findByStatus(status);
	}

	public void save(Pet pet) {
		petRepository.save(pet);

	}

  	public void delete(Long id) {
		petRepository.delete(id);
  }
}
