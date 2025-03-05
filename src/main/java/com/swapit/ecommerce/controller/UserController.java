package com.swapit.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.swapit.ecommerce.entity.LoginCredentials;
import com.swapit.ecommerce.entity.User;
import com.swapit.ecommerce.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping("/register/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> registerUser(@RequestBody @Valid User user, BindingResult bindingResult) {
		return ResponseEntity.ofNullable(userService.registerUser(user));
	}

	@GetMapping("/getUserDetails/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> getUserDetails(@PathVariable long id) {
		return ResponseEntity.ofNullable(userService.getUserDetails(id));
	}

	@GetMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> loginUser(@RequestBody LoginCredentials credentials) {
		log.info("Login process started");
		log.info("UserName : {}, Password : {}", credentials.getEmail(), credentials.getPassword());
		return ResponseEntity.ofNullable(userService.loginUser(credentials));
	}

}
