package com.api.vuttr.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.vuttr.security.jwt.filter.JwtTokenFilter;
import com.api.vuttr.security.jwt.provider.JwtTokenProvider;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

	private final JwtTokenProvider tokenService;

	public JwtConfigurer(JwtTokenProvider tokenService) {
		this.tokenService = tokenService;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtTokenFilter filter = new JwtTokenFilter(tokenService);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
}
