package com.api.vuttr.controller;

import java.net.URI;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.vuttr.dto.UsersDTO;
import com.api.vuttr.helper.tools.UsersHelper;
import com.api.vuttr.security.dto.CredentialsDTO;
import com.api.vuttr.service.AuthService;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
@Api(tags = { "Authentication EndPoint" })
public class AuthController {

	private final AuthService service;
	private UsersHelper helper;

	public AuthController(AuthService service, UsersHelper helper) {
		this.service = service;
		this.helper = helper;
	}

	@PostMapping(value = "/signin", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Authenticates a user with credentials")
	public ResponseEntity<Object> signinUser(@Valid @RequestBody CredentialsDTO credentialsDTO, BindingResult result) {

		log.info("Checks if credentials error has occurred");
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(credentialsDTO);
		}

		log.info("Confirms user authentication and returns token for access to other API routes");
		Object credentials = service.signinUser(credentialsDTO);

		return ResponseEntity.ok(credentials);
	}

	@PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Creates a new user")
	public ResponseEntity<UsersDTO> createUser(@Valid @RequestBody UsersDTO usersDTO, BindingResult result) {

		log.info("Checks if the information is correct by the validation implemented!");
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(usersDTO);
		}

		log.info("Converts data to entity when sending through the service and returns converting to DTO");
		UsersDTO user = helper.toModel(service.createUser(helper.toEntity(usersDTO)));

		log.info("Adds the url's URI with Id!");
		URI uri = getUri(user.getId());

		return ResponseEntity.created(uri).body(user);
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
