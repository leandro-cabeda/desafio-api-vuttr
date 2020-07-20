package com.api.vuttr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.vuttr.dto.ToolsDTO;
import com.api.vuttr.helper.tools.ToolsHelper;
import com.api.vuttr.service.ToolsService;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/tools")
@Api(tags = {"Tools EndPoint"})
public class ToolsController {

	private final ToolsService service;
	private final ToolsHelper helper;

	public ToolsController(ToolsService service, ToolsHelper helper) {
		this.service = service;
		this.helper = helper;
	}

	@GetMapping(value = "/id/{id}", produces = "application/json")
	@ApiOperation(value = "Tool search by id")
	public ResponseEntity<ToolsDTO> findToolById(
			@ApiParam(value = "Id to search for a particular tool", required = true, example = "1")
			@PathVariable("id") Long id) {

		log.info("Returning the tool and converting them to toolsDTO!");
		ToolsDTO tool = helper.toModel(service.findIdTools(id));

		return ResponseEntity.ok(tool);
	}

	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Lists all tools")
	public ResponseEntity<List<ToolsDTO>> findAllTools() {

		log.info("Returning the list of entity tools and converting them to toolsDTO!");
		List<ToolsDTO> tools = helper.toModel(service.findAllTools());

		return ResponseEntity.ok(tools);
	}

	@GetMapping(value = "/{tag}", produces = "application/json")
	@ApiOperation(value = "Lists all tools by the specified tag")
	public ResponseEntity<List<ToolsDTO>> findAllToolsByTag(
			@ApiParam(value = "Tag to search which tools they have", required = true, example = "node")
			@PathVariable("tag") String tag) {

		log.info("Returning the list of tools from the specified entity by the inserted tag and converting them to toolsDTO!");
		List<ToolsDTO> tools = helper.toModel(service.findAllToolsByTag(tag));

		return ResponseEntity.ok(tools);
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Creates a new tool")
	public ResponseEntity<ToolsDTO> createTools(@Valid @RequestBody ToolsDTO toolsDTO, BindingResult result) {

		log.info("Checks if the information is correct by the validation implemented!");
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(toolsDTO);
		}

		log.info("Converts data to entity when sending through the service and returns converting to DTO");
		ToolsDTO tools = helper.toModel(service.createTools(helper.toEntity(toolsDTO)));

		log.info("Adds the url's URI with Id!");
		URI uri = getUri(tools.getId());

		return ResponseEntity.created(uri).body(tools);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ApiOperation(value = "Delete a tag")
	public ResponseEntity<Void> deleteTools(
			@ApiParam(value = "Id to delete a specific tool", required = true, example = "1")
			@PathVariable("id") Long id) {

		log.info("Receive the tool id in the parameter and delete!");
		service.deleteToolsById(id);

		return ResponseEntity.noContent().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
