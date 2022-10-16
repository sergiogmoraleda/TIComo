package equipo5.loginGrego.services;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equipo5.loginGrego.dao.UserRepository;
import equipo5.loginGrego.model.User;

/*
 * To do:
 * - Esto habría que implementarlo en un UserService
 * - Realizar la comprobación del rol, y mirar si implementarlo con lo del servlet o como lo de Macario
 * */

// ESTO ES UN PROTOTIPO

@Service
public class LoginService {

	@Autowired
	private UserRepository userDAO;

	public void login(JSONObject jso) throws Exception {
		Optional<User> userAux = this.userDAO.findByUsername(jso.getString("name"));

		if (!userAux.isPresent())
			throw new Exception("Credenciales inválidas");

		User user = userAux.get();
		String pwd = org.apache.commons.codec.digest.DigestUtils.sha512Hex(jso.getString("pwd"));

		if (!user.getPwd().equals(pwd))
			throw new Exception("Credenciales inválidas");

		switch (user.getRol()) {
		case "admin":
			// devolver url para las zona del admin
			break;
		case "rider":
			// devolver url para las zona del rider
			break;
		case "user":
			// devolver url para las zona del usuario normal
			break;
		}
	}
}
