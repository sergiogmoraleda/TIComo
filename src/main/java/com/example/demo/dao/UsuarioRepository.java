package com.example.demo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
	
	public Usuario findByEmail(String email);
	public Usuario findByNombre(String nombre);


}