package com.example.demo.model;


import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Usuario")
public class Usuario {

	@Id
	private int id;
	
	private String nombre;
	private String apellidos;
	private String nif;
	private String direccion;
	private String telefono;
	private String email;
	private String pwd;
	
	private Set <Roles> rol;
	
	public Usuario() {}

	public Usuario( String nombre, String apellidos, String nif, String direccion, String telefono, String email,
			String pwd) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set<Roles> getRol() {
		return rol;
	}

	public void setRol(Set<Roles> rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, direccion, email, id, nif, nombre, pwd, rol, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(nif, other.nif)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pwd, other.pwd)
				&& Objects.equals(rol, other.rol) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion="
				+ direccion + ", telefono=" + telefono + ", email=" + email + ", pwd=" + pwd + ", rol=" + rol + "]";
	}

	
}