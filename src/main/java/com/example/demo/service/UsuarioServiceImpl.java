package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.exception.CustomeFieldValidationException;
import com.example.demo.model.Usuario;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	UsuarioRepository uRepository;
	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Usuario createUser(Usuario usuario) throws Exception {
//		&& checkPasswordValid(usuario)
		if (checkUsernameAvailable(usuario) ) {
//			String encodedPassword = bCryptPasswordEncoder.encode(usuario.getPwd());
//			usuario.setPwd(encodedPassword);
			usuario = uRepository.save(usuario);
		}
		return usuario;
	}
	
	private boolean checkUsernameAvailable(Usuario usuario) throws Exception {
		Usuario userFound = uRepository.findByNombre(usuario.getNombre());
		if (userFound != null) {
			throw new CustomeFieldValidationException("Username no disponible","username");
		}
		return true;
	}

//	private boolean checkPasswordValid(Usuario usuario) throws Exception {
//		if (usuario.getConfirmPassword() == null || usuario.getConfirmPassword().isEmpty()) {
//			throw new CustomeFieldValidationException("Confirm Password es obligatorio","confirmPassword");
//		}
//		
//		if ( !usuario.getPassword().equals(usuario.getConfirmPassword())) {
//			throw new CustomeFieldValidationException("Password y Confirm Password no son iguales","password");
//		}
//		return true;
//	}

	@Override
	public Usuario findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return uRepository.findByEmail(email);
	}

	@Override
	public Iterable<Usuario> getAllUsers() {
		// TODO Auto-generated method stub
		return uRepository.findAll();
	}
}
