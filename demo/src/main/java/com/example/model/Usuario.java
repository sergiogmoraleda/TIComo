package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Usuario")
public class Usuario {

    @Id
    private int id;
    private String email;
    private String pwd;
    private String rol_usuario;

    public Usuario() {

    }
    
    public Usuario(int id, String email, String pwd, String rol_usuario){
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.rol_usuario = rol_usuario;
    }
}
