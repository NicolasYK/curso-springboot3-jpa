package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.repositories.UserRepository;

// Criando uma camada de serviços para n sobrecarregar o controlador
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj_user = userRepository.findById(id);
		return obj_user.get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
}