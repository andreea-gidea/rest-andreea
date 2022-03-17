package com.endava.rest.repository;

import com.endava.rest.model.Category;
import com.endava.rest.model.Tag;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class TagRepository {

	private Map<Long, Tag> tags = new HashMap<>();

	@PostConstruct
	private void init() {
		createTags();
	}

	private void createTags() {
		Tag tag = new Tag();
		tag.setId(1L);
		tag.setName("Stuff");
		tags.put(tag.getId(), tag);

		Tag tag2 = new Tag();
		tag2.setId(2L);
		tag2.setName("Stuff");
		tags.put(tag2.getId(), tag2);
	}

	public List<Tag> getTags() {
		return new ArrayList<>(tags.values());
	}


}
