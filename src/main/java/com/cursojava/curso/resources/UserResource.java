package com.cursojava.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.entities.User;

// Disponibilizando recursos web do usuário.
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// Método endpoint para acessar usuário
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "912345678", "12345");
		return ResponseEntity.ok().body(u);
	}
}
