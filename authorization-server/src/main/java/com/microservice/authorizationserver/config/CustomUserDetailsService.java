package com.microservice.authorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomUserDetailsService {
    
    @Bean
	UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder()
				.username("user")
				.password("{noop}password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(userDetails);
	}
}
