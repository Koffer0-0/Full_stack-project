package com.example.snickersdevops.tasks;

import com.example.snickersdevops.service.usermanagement.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TokenTasks {

	@Autowired
	List<TokenService<?>> tokenServices;

	@Scheduled(fixedDelay = 20000)
	public void cleanUpExpiredTokens() {
		for (TokenService<?> tokenService : tokenServices) {
			tokenService.invalidateExpiredTokensPreviousTo(new Date());
		}
	}
}
