package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
	
	List<Usuario> findByNombre(String nombre);

}