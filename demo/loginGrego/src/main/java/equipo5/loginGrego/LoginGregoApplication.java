package equipo5.loginGrego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import equipo5.loginGrego.dao.UserRepository;
import equipo5.loginGrego.model.User;

@SpringBootApplication
public class LoginGregoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userDao;

	public static void main(String[] args) {
		SpringApplication.run(LoginGregoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User usr1 = new User(1, "barchi", "1234", "barchi2001@gmail.com", "admin");
		userDao.save(usr1);
	}

}
