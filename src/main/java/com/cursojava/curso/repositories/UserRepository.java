package com.cursojava.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.curso.entities.User;

// Criando um repositório do usuário, depefindo operações de interação com eles.
public interface UserRepository extends JpaRepository<User, Long>{
	

}
