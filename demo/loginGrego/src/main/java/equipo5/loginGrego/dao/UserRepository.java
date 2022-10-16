package equipo5.loginGrego.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import equipo5.loginGrego.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
