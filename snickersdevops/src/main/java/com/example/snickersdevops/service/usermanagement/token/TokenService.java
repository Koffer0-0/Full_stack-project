package com.example.snickersdevops.service.usermanagement.token;

import com.example.snickersdevops.exceptions.InvalidTokenException;
import com.example.snickersdevops.model.TokenModel;
import com.example.snickersdevops.model.User;

import java.util.Date;

public interface TokenService<T extends TokenModel> {
	T generateTokenForUser(User user);

	void validateTokenForUser(User user, String token) throws InvalidTokenException;

	void invalidateToken(String token);

	void invalidateExpiredTokensPreviousTo(Date date);
}
