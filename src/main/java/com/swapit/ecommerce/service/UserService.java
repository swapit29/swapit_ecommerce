package com.swapit.ecommerce.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swapit.ecommerce.entity.LoginCredentials;
import com.swapit.ecommerce.entity.User;
import com.swapit.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repo;

	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public User getUserDetails(long id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return new User();
	}
	
	public User loginUser(LoginCredentials credentials) {
		Optional<User> user = repo.findByEmail(credentials.getEmail());
		if (user.isPresent() && passwordEncoder.matches(credentials.getPassword(), user.get().getPassword())) {
			return user.get();
		}
		return new User();
	}

}
