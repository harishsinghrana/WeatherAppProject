package in.hr.weather.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hr.weather.app.model.User;
import in.hr.weather.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void activateUser(String username) {
		Optional<User> optional = userRepository.findById(username);
		if (optional.isPresent()) {
			User user = optional.get();
			user.setActive(true);
			userRepository.save(user);
		} else {
			User user = new User();
			user.setName(username);
			user.setActive(true);
			userRepository.save(user);
		}
	}

	public String deactivateUser(String username) {
		Optional<User> optional = userRepository.findByName(username);
		if (!optional.isEmpty() && optional.isPresent()) {
			User user = optional.get();
			user.setActive(false);
			userRepository.save(user);
			return "DEACTIVATE_SUCCESS";
		}
		return "NO_USER_TO-DEACTIVATE";
	}

}
