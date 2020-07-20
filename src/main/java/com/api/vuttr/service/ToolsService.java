package com.api.vuttr.service;

import org.springframework.stereotype.Service;

import com.api.vuttr.entity.*;
import com.api.vuttr.exception.*;
import com.api.vuttr.repository.*;
import static java.util.stream.Collectors.*;

import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
@Service
public class ToolsService {

	private final ToolsRepository repository;

	public ToolsService(ToolsRepository repository) {
		this.repository = repository;
	}

	public ToolsEntity findIdTools(Long id) {
		log.info("Search for the tool by id: " + id);
		Optional<ToolsEntity> toolOpt = repository.findById(id);

		log.info("Checks if the tool not exists");
		if (!toolOpt.isPresent()) {
			throw new NotFound("Tool with id :" + id + " not found!");
		}

		log.info("Convert the tags of tool and return");
		return toolByTagsToConverterString(toolOpt.get());
	}

	public List<ToolsEntity> findAllTools() {
		log.info("Retrieves the list of tools in the bank!");
		List<ToolsEntity> tools = repository.findAll();

		log.info("Convert the list tags of tools and return");
		return toolsByTagsToConverterString(tools);
	}

	public List<ToolsEntity> findAllToolsByTag(String tag) {
		log.info("Retrieve a list of tools by the specified tag!");
		List<ToolsEntity> tools = repository.findAllToolsByTag(tag);

		log.info("Convert the list tags of tools and return");
		return toolsByTagsToConverterString(tools);
	}

	public ToolsEntity createTools(ToolsEntity entity) {
		log.info("Checks if the title or link already exists in the registered bank!");
		ToolsEntity toolsEntity = repository.findByTitleOrLinkIgnoreCase(entity.getTitle(), entity.getLink());

		if (toolsEntity != null)
			throw new RegisterExists("Error: record already contained in the bank!");

		log.info("Insert the list of returned tag objects to save for the tool");
		entity.setTagsObject(toolsByTagsToConverterObject(entity));

		log.info("Saving a new tool!");
		return repository.save(entity);
	}

	public void deleteToolsById(Long id) {
		log.info("Retrieves the tool using the findIdTools function by passing id: " + id
				+ " and deleting the tool in the bank with return");
		repository.deleteById(findIdTools(id).getId());
	}

	private List<TagsEntity> toolsByTagsToConverterObject(ToolsEntity entity) {

		log.info("Retrieves the list of tags and creates the tag objects for the tool and returns as a list");
		List<TagsEntity> tagsObject = entity.getTags().stream().map(tagName -> new TagsEntity(tagName, entity))
				.collect(toList());

		return tagsObject;
	}

	private List<ToolsEntity> toolsByTagsToConverterString(List<ToolsEntity> tools) {

		log.info("Converts the list of object tags to a String list returned from the tools list");
		tools.forEach(tool -> tool.getTagsObject().forEach(tagObject -> tool.getTags().add(tagObject.getName())));

		return tools;
	}

	private ToolsEntity toolByTagsToConverterString(ToolsEntity tool) {

		log.info("Converts the list of object tags to a String list returned to the tool");
		tool.getTagsObject().forEach(tagObject -> tool.getTags().add(tagObject.getName()));

		return tool;
	}
}
