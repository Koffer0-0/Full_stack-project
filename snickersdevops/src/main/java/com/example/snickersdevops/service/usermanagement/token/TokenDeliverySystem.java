package com.example.snickersdevops.service.usermanagement.token;

import jorge.rv.quizzz.model.TokenModel;
import jorge.rv.quizzz.model.TokenType;
import jorge.rv.quizzz.model.User;
import org.springframework.scheduling.annotation.Async;

public interface TokenDeliverySystem {
	@Async
	void sendTokenToUser(TokenModel token, User user, TokenType tokenType);
}
