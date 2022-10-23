package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.exception.CustomeFieldValidationException;
import com.example.demo.dao.RolRepository;
import com.example.demo.model.Roles;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
@Controller
public class usuarioController {

	@Autowired
	private RolRepository rRepository;
	@Autowired
	private UsuarioService uService;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		Roles usuarioRol = rRepository.findByNombre("USUARIO");
		List<Roles> roles = Arrays.asList(usuarioRol);
		
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("roles",roles);
		return "user-form/user-signup";
	}
	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("userForm")Usuario usuario, BindingResult result, ModelMap model) {
		Roles usuarioRol = rRepository.findByNombre("USUARIO");
		List<Roles> roles = Arrays.asList(usuarioRol);
		model.addAttribute("userForm", usuario);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
			return "user-form/user-signup";
		}else {
			try {
				uService.createUser(usuario);

			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return "";
	}
	
	@GetMapping({"/","/login"})
    public String index() {
        return "index";
    }
	
	private void baseAttributerForUserForm(Model model, Usuario user,String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", uService.getAllUsers());
		model.addAttribute("roles",rRepository.findAll());
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		baseAttributerForUserForm(model, new Usuario(), "listTab" );
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, "formTab");
		}else {
			try {
				uService.createUser(user);
				baseAttributerForUserForm(model, new Usuario(), "listTab" );
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, user, "formTab" );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForUserForm(model, user, "formTab" );
			}
		}
		return "user-form/user-view";
	}
}
	
 