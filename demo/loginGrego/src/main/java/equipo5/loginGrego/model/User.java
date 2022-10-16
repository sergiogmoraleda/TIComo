package equipo5.loginGrego.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// ESTO ES UN PROTOTIPO

@Document(collection = "Usuarios")
public class User {

	@Id
	private int id;

	private String username;
	private String pwd;
	private String email;
	private String rol;
	
	public User(int id, String username, String pwd, String email, String rol) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
