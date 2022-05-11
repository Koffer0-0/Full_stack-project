package com.example.snickersdevops.service.usermanagement.token;

import com.example.snickersdevops.model.TokenModel;
import com.example.snickersdevops.model.TokenType;
import com.example.snickersdevops.model.User;
import org.springframework.scheduling.annotation.Async;

public interface TokenDeliverySystem {
	@Async
	void sendTokenToUser(TokenModel token, User user, TokenType tokenType);
}
