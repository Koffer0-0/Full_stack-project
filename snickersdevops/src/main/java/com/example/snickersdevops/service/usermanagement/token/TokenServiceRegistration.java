package com.example.snickersdevops.service.usermanagement.token;

import com.example.snickersdevops.model.RegistrationToken;
import com.example.snickersdevops.repository.RegistrationTokenRepository;
import com.example.snickersdevops.service.usermanagement.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceRegistration extends TokenServiceAbs<RegistrationToken> {

	@Value("${quizzz.tokens.registration_mail.timeout}")
	private Integer expirationTimeInMinutes = 86400;

	@Autowired
	public TokenServiceRegistration(RegistrationTokenRepository mailTokenRepository, TokenGenerator tokenGenerator) {
		super(tokenGenerator, mailTokenRepository);
	}

	@Override
	protected RegistrationToken create() {
		return new RegistrationToken();
	}

	@Override
	protected int getExpirationTimeInMinutes() {
		return expirationTimeInMinutes;
	}

	public void setExpirationTimeInMinutes(Integer expirationTimeInMinutes) {
		this.expirationTimeInMinutes = expirationTimeInMinutes;
	}
}
