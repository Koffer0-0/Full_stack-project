package com.example.snickersdevops.service.usermanagement;

import com.example.snickersdevops.model.ForgotPasswordToken;
import com.example.snickersdevops.model.TokenType;
import com.example.snickersdevops.model.User;
import com.example.snickersdevops.service.UserService;
import com.example.snickersdevops.service.usermanagement.token.TokenDeliverySystem;
import com.example.snickersdevops.service.usermanagement.token.TokenServiceForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private UserService userService;
	private TokenServiceForgotPassword forgotPasswordService;
	private TokenDeliverySystem tokenDeliveryService;

	@Autowired
	public UserManagementServiceImpl(UserService userService, TokenServiceForgotPassword forgotPasswordService,
			TokenDeliverySystem tokenDeliveryService) {
		this.forgotPasswordService = forgotPasswordService;
		this.tokenDeliveryService = tokenDeliveryService;
		this.userService = userService;
	}

	@Override
	public void resendPassword(User user) {
		ForgotPasswordToken token = forgotPasswordService.generateTokenForUser(user);
		tokenDeliveryService.sendTokenToUser(token, user, TokenType.FORGOT_PASSWORD);
	}

	@Override
	public void verifyResetPasswordToken(User user, String token) {
		forgotPasswordService.validateTokenForUser(user, token);
	}

	@Override
	public void updatePassword(User user, String password) {
		userService.updatePassword(user, password);
	}

}
