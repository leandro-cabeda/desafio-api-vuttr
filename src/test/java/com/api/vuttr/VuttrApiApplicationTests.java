package com.api.vuttr;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.api.vuttr.entity.RolesEntity;
import com.api.vuttr.entity.UsersEntity;
import com.api.vuttr.repository.RolesRepository;
import com.api.vuttr.repository.UsersRepository;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class VuttrApiApplicationTests {

	@Autowired
	private UsersRepository rep;
	
	@Autowired 
	RolesRepository repRol;
	
	@Autowired
	private Gson gson;
	
	@Test
	void setUserRoles() {
		
		BCryptPasswordEncoder encode= new BCryptPasswordEncoder();
		
		UsersEntity user = new UsersEntity();
		
		RolesEntity role= new RolesEntity();
		RolesEntity role2= new RolesEntity();
		
		
		role.setDescription("ADMIN");
		role2.setDescription("USER");
		
		RolesEntity rol=repRol.save(role);
		RolesEntity rol2=repRol.save(role2);
		
		user.setUserName("leo");
		user.setEmail("leo.cabeda@hotmail.com");
		user.setPassword(encode.encode("admin123"));
		user.setRoles(Arrays.asList(rol,rol2));
		
		UsersEntity use=rep.save(user);
		
		log.info(gson.toJson(use));
		
	}

}
