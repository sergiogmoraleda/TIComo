package com.example.model;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class UsuarioTest{

    @Test
    public void testCrearUsuario(){
        //constructor vacio
        Usuario usuario = new Usuario();
        System.out.println(usuario.toString());
        //constructor lleno
        Usuario usuariolleno = new Usuario(1,"johnDoe@gmail.com", "contrasena", "Usuario");

    }
}