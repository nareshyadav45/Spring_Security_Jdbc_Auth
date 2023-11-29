package com.security.jdbc.auth.secuirty.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((request) -> 
		request.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user")
	    .hasAnyRole("USER", "ADMIN")
	    .antMatchers("/welcome", "/").permitAll()
	    .anyRequest().authenticated()
		).formLogin().and().httpBasic();
		return http.build();
	}
	
	
	@Autowired
	public void authManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
		try {
			authenticationManagerBuilder.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("select username,password,enabled from jdbcauthsec.users where username=?")
			.authoritiesByUsernameQuery("select username,authority from jdbcauthsec.authorities where username=?");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
