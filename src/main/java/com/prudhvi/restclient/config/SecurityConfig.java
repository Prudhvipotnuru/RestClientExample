package com.prudhvi.restclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain get(HttpSecurity http) {
		http.authorizeHttpRequests((req)->req
				.requestMatchers("/","/passenger","/bookTicket")
				.permitAll()
				.anyRequest().authenticated()
		).formLogin(req->req.permitAll());
		return http.build();
	}
}
