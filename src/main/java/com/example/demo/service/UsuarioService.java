package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;

@Service
public interface UsuarioService{


	public Iterable<Usuario> getAllUsers();
	
	public Usuario findUserByEmail(String email);
	
	public Usuario createUser(Usuario usuario) throws Exception;
}
