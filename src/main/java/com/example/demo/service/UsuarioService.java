package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.model.Usuario;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository uRepository;
	
	public Usuario findUserByEmail(String email) {
	    return uRepository.findByEmail(email);
	}
	
	public void guardarUsuario(Usuario u1) {
		 //ENCRIPTAR CONTRASEÑA
		//AÑADIR ROL
	    uRepository.save(u1);
	}
}
