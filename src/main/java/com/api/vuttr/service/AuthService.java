package com.api.vuttr.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.api.vuttr.entity.UsersEntity;
import com.api.vuttr.exception.RegisterExists;
import com.api.vuttr.repository.UsersRepository;
import com.api.vuttr.security.dto.CredentialsDTO;
import com.api.vuttr.security.jwt.exception.CredentialsException;
import com.api.vuttr.security.jwt.provider.JwtTokenProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService {

	private final JwtTokenProvider jwtService;
	private final UsersRepository repository;

	public AuthService(JwtTokenProvider jwtService, UsersRepository repository) {
		this.jwtService = jwtService;
		this.repository = repository;
	}

	public Object signinUser(CredentialsDTO credentials) {
		
		log.info("Retrieves the user by username and password!");
		UsersEntity user = repository.findByUserNameAndPasswordIgnoreCase(credentials.getUsername(),
				credentials.getPassword());

		log.info("Checks that this user does not exist with your credentials!");
		if (user == null) {
			throw new CredentialsException("Invalid username : " + credentials.getUsername() + " or password: "
					+ credentials.getPassword() + " provided!");
		}

		String token = jwtService.createToken(user.getUsername(), user.getRoles());

		Map<String, String> obj = new HashMap<>();
		obj.put("username", user.getUsername());
		obj.put("token", token);

		return obj;
	}

	public UsersEntity createUser(UsersEntity userEntity) {
		UsersEntity user = repository.findByUserNameOrEmailIgnoreCase(userEntity.getUsername(), userEntity.getEmail());

		log.info("Check if the user does exist by username or email");
		if (user != null)
			throw new RegisterExists("Error: record already contained in the bank!");

		log.info("Create a new user");
		return repository.save(userEntity);
	}
}
