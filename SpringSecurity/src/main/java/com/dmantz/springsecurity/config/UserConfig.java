
package com.dmantz.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfig  {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		    provider.setUserDetailsService(userDetailsService);
		    provider.setPasswordEncoder(new BCryptPasswordEncoder() ); // using NoOpPasswordEncoder for simple passwords
		    return provider;
		
	}
	

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeHttpRequests((auth)->auth.anyRequest().authenticated()
				).httpBasic( Customizer.withDefaults());
		return http.build();
		
	}


}
