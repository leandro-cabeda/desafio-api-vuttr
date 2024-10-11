package com.api.vuttr.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.api.vuttr.security.jwt.JwtConfigurer;
import com.api.vuttr.security.jwt.authorize.AccessDenied;
import com.api.vuttr.security.jwt.authorize.JwtAuthenticationEntryPoint;
import com.api.vuttr.security.jwt.provider.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtTokenProvider tokenService;
	private final AccessDenied authorizeAccess;
	private final JwtAuthenticationEntryPoint authorizeAuthentication;

	public SecurityConfig(JwtTokenProvider tokenService, AccessDenied authorizeAccess,
			JwtAuthenticationEntryPoint authorizeAuthentication) {
		this.tokenService = tokenService;
		this.authorizeAccess = authorizeAccess;
		this.authorizeAuthentication = authorizeAuthentication;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests()
				.antMatchers("/auth/**", "/swagger*/**", "/configuration/**", "/webjars/**", "/api-docs/**")
				.permitAll()
				.antMatchers(HttpMethod.GET, "/tools/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.DELETE, "/tools/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/tools/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/tools/**").hasAuthority("ADMIN")
				//.antMatchers(HttpMethod.GET, "/tools/**").hasAnyRole("ADMIN","USER")
                //.antMatchers(HttpMethod.DELETE, "/tools/**").hasRole("ADMIN")
                //.antMatchers(HttpMethod.POST, "/tools/**").hasRole("ADMIN")
				.antMatchers("/tools/**").authenticated()
				.and()
				.apply(new JwtConfigurer(tokenService));

		http.exceptionHandling()
		.accessDeniedHandler(authorizeAccess)
		.authenticationEntryPoint(authorizeAuthentication);
	}
}
