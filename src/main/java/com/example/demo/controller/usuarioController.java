package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
@Controller
public class usuarioController {

	@Autowired
	private UsuarioService uService;

	//MODEL NECESITA INTERFAZ
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView registro() {
	    ModelAndView modelAndView = new ModelAndView();
	    Usuario usuario = new Usuario();
	    modelAndView.addObject("Usuario", usuario);
	    modelAndView.setViewName("registro");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	public ModelAndView crearNuevoUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    Usuario usuarioAux = uService.findUserByEmail(usuario.getEmail());
	    if (usuarioAux != null) {
	        bindingResult
	                .rejectValue("email", "error.user",
	                        "Este Email esta registrado en la base de datos del sistema.");
	    }
	    if (bindingResult.hasErrors()) {
	        modelAndView.setViewName("registro");
	    } else {
	        uService.guardarUsuario(usuario);
	        modelAndView.addObject("successMessage", "Usuario registrado correctamente.");
	        modelAndView.addObject("Usuario", new Usuario());
	        modelAndView.setViewName("login");

	    }
	    return modelAndView;
	}
}
	
 