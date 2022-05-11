package com.example.snickersdevops.service.usermanagement;


import com.example.snickersdevops.model.User;

public interface UserManagementService {

	void resendPassword(User user);

	void verifyResetPasswordToken(User user, String token);

	void updatePassword(User user, String password);

}
