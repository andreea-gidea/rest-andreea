package com.endava.rest.repository;

import com.endava.rest.model.Category;
import com.endava.rest.model.PersonNM;
import com.endava.rest.model.Pet;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

@Repository
public class CategoryRepository {

	private Map<Long, Category> categories = new HashMap<>();

	@PostConstruct
	private void init() {
		createCategories();
	}

	private void createCategories() {
		Category category = new Category();
		category.setId(1L);
		category.setName("Dogs");
		categories.put(category.getId(), category);

		Category category2 = new Category();
		category.setId(2L);
		category.setName("Cats");
		categories.put(category2.getId(), category2);
	}

	public Optional<Category> findById(Long id) {
		return Optional.ofNullable(categories.getOrDefault(id, null));


	}
}
