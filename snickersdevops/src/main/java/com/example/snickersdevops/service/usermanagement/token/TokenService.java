package com.example.snickersdevops.service.usermanagement.token;

import jorge.rv.quizzz.exceptions.InvalidTokenException;
import jorge.rv.quizzz.model.TokenModel;
import jorge.rv.quizzz.model.User;

import java.util.Date;

public interface TokenService<T extends TokenModel> {
	T generateTokenForUser(User user);

	void validateTokenForUser(User user, String token) throws InvalidTokenException;

	void invalidateToken(String token);

	void invalidateExpiredTokensPreviousTo(Date date);
}
