package com.cursojava.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// Post da inserção de um novo usuário no bd
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	// Deletando um usuário do bd
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// Update do usuário no bd
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
