package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.usuarioController;
import com.example.demo.dao.UsuarioRepository;
import com.example.demo.model.Usuario;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
 
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception{
		
		
	}
}
