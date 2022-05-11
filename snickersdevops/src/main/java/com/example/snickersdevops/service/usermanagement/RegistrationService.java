package com.example.snickersdevops.service.usermanagement;


import com.example.snickersdevops.model.User;

public interface RegistrationService {
	User startRegistration(User user);

	User continueRegistration(User user, String token);

	boolean isRegistrationCompleted(User user);
}
