package com.example.snickersdevops.service.usermanagement;

import jorge.rv.quizzz.model.User;
import jorge.rv.quizzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationServiceSimple implements RegistrationService {

	@Autowired
	private UserService userService;

	@Override
	public User startRegistration(User user) {
		User newUser = userService.saveUser(user);
		userService.setRegistrationCompleted(newUser);

		return newUser;
	}

	@Override
	public User continueRegistration(User user, String token) {
		return null;
	}

	@Override
	public boolean isRegistrationCompleted(User user) {
		return userService.isRegistrationCompleted(user);
	}

}
