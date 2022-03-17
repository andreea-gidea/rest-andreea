package com.endava.rest.repository;

import com.endava.rest.model.Pet;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class PetRepository {

	private Map<Long, Pet> pets = new HashMap<>();

	@PostConstruct
	private void init() {
		createPersons();
	}

	private void createPersons() {
		CategoryRepository categoryRepository = new CategoryRepository();
		TagRepository tagRepository = new TagRepository();
		Pet pet = new Pet();
		pet.setId(1L);
		pet.setCategory(categoryRepository.findById(1L).orElse(null));
		pet.setName("Gagauta");
		pet.setTags(tagRepository.getTags());
		pet.setStatus("AVAILABLE");
		pets.put(pet.getId(), pet);

		Pet pet2 = new Pet();
		pet2.setId(2L);
		pet2.setCategory(categoryRepository.findById(2L).orElse(null));
		pet2.setName("Liliana");
		pet2.setTags(tagRepository.getTags());
		pet2.setStatus("PENDING");
		pets.put(pet2.getId(), pet2);

		Pet pet3 = new Pet();
		pet3.setId(2L);
		pet3.setCategory(categoryRepository.findById(1L).orElse(null));
		pet3.setName("Nicolaman");
		pet3.setTags(tagRepository.getTags());
		pet3.setStatus("SOLD");
		pets.put(pet3.getId(), pet3);

	}

	public List<Pet> findAll() {
		return new ArrayList<>(pets.values());
	}

	public void save(Pet pet) {
		pets.compute(pet.getId(), (key, value) -> pet);
	}

	public Optional<Pet> findById(Long id) {
		return Optional.ofNullable(pets.getOrDefault(id, null));
	}

	public Optional<Pet> findByStatus(String status) {
		return Optional.ofNullable(pets.getOrDefault(status, null));
	}

	public void delete(Long id) {
		pets.remove(id);
	}
}
