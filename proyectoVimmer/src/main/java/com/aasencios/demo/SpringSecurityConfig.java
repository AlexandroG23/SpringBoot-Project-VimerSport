package com.aasencios.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.aasencios.demo.model.servicio.UserService;

@Configuration
public class SpringSecurityConfig {

	@Autowired
	private UserService userService;
	
	@Bean
	public static BCryptPasswordEncoder encriptarPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/").defaultSuccessUrl("/principal", true).permitAll()
			.and().logout().permitAll();
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
		return (web) -> web.ignoring().antMatchers("/css/**","/css2/**","/js/**","/js2**","/img/**");
	}
	
	/*@Bean
	public InMemoryUserDetailsManager configureAuthentication() {
		List<UserDetails> listaUsuarios = new ArrayList<>();
		List<GrantedAuthority> rolesClientes = new ArrayList<>();
		List<GrantedAuthority> rolesAdminsitradores = new ArrayList<>();
		
		rolesClientes.add(new SimpleGrantedAuthority("USER"));
		rolesAdminsitradores.add(new SimpleGrantedAuthority("ADMIN"));
		
		listaUsuarios.add(new User("Administrador","{noop}123456", rolesAdminsitradores));
		listaUsuarios.add(new User("Angelo","{noop}123456", rolesClientes));
		
		return new InMemoryUserDetailsManager(listaUsuarios);
	}*/
}
