package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		Usuario a = new Usuario(1,"NACHO","090908");
		usuarioRepository.save(a);
		
		Usuario pi2 = new Usuario(2, "Calero", "Muñoz");
		Usuario pi3 = new Usuario(3, "Adan", "Antonio");	
		usuarioRepository.saveAll(Arrays.asList(pi2,pi3));
		
		
	}
}
