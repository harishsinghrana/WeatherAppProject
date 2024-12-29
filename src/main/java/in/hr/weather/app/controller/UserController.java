package in.hr.weather.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.hr.weather.app.service.UserService;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(name = "UserController", value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/activate/{username}")
	public ResponseEntity<?> activeUser(@PathVariable @NotBlank String userName) {
		userService.activateUser(userName);
		return ResponseEntity.ok("USER_ACTIVATE_SUCCESS");

	}
	
	@GetMapping("/deactivate/{username}")
	public ResponseEntity<?> deactiveUser(@PathVariable @NotBlank String userName) {
		String status =userService.deactivateUser(userName);
		return ResponseEntity.ok(status);

	}
}
