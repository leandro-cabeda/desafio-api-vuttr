package com.api.vuttr.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.vuttr.entity.UsersEntity;
import com.api.vuttr.exception.UsernameNotFoundExcept;
import com.api.vuttr.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	private final UsersRepository repository;

	public UserService(UsersRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity user = repository.findByUserNameIgnoreCase(username);

		log.info("Check if the user does not exist by username");
		if (user == null) {
			throw new UsernameNotFoundExcept("Username: " + username + " of user not found");
		}

		return user;
	}
}
