package com.cursojava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.services.UserService;

// Disponibilizando recursos web do usuário.
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// criando dependência
	@Autowired
	private UserService service;
	
	// Método endpoint retornando todos os usuários.
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Método endpoint que precisa da URL, definindo o valor nele.
	@GetMapping(value= "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){ // Dizendo para o Spring a val utilizavel.
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
