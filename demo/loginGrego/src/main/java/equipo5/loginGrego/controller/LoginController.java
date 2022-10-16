package equipo5.loginGrego.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import equipo5.loginGrego.services.LoginService;

/*
 * To do:
 * - Esto habría que implementarlo en UserController
 * - Mirar si hacerlo servlet
 * */

// ESTO ES UN PROTOTIPO

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public void login(@RequestBody Map<String, Object> info, HttpSession sesion) {
		try {
			JSONObject jso = new JSONObject(info);
			sesion.setAttribute("userName", jso.getString("name"));
			loginService.login(jso);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
