package in.hr.weather.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hr.weather.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public Optional<User> findByName(String username);
}
