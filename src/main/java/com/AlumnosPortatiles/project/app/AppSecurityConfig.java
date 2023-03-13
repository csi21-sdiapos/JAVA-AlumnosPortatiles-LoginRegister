package com.AlumnosPortatiles.project.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	DataSource seguridadDataSource;

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(seguridadDataSource).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
			
				.antMatchers("/navigateToAlumnos/**").hasRole("EMPLOYEE")
				.antMatchers("/navigateToPortatiles/**").hasRole("EMPLOYEE")
				
				.antMatchers("/navigateToCreateFormAlumno/**").hasRole("ADMIN")
				.antMatchers("/navigateToCreateFormPortatil/**").hasRole("ADMIN")
				.and()
				
			.formLogin()
				.loginPage("/navigateToLogin")
				.loginProcessingUrl("/loginUser")
				.permitAll()
				.and()
				
			.logout()
				.permitAll()
				.and()
				
			.exceptionHandling()
				.accessDeniedPage("/accesoDenegado")
		;
		
		// https://www.baeldung.com/spring-security-csrf
		http.csrf().disable();
		// https://stackoverflow.com/questions/65894268/how-does-headers-frameoptions-disable-work
		http.headers().frameOptions().disable();
	}

}