package com.example.snickersdevops.service.accesscontrol;

import jorge.rv.quizzz.exceptions.UnauthorizedActionException;
import jorge.rv.quizzz.model.AuthenticatedUser;
import jorge.rv.quizzz.model.Quiz;
import org.springframework.stereotype.Service;

@Service("AccessControlQuiz")
public class AccessControlServiceQuiz extends AccessControlServiceUserOwned<Quiz> {

	/*
	 * As long as the user is authenticated, it can create a Quiz.
	 */
	@Override
	public void canUserCreateObject(AuthenticatedUser user, Quiz object) throws UnauthorizedActionException {
		if (user == null) {
			throw new UnauthorizedActionException();
		}
	}

}
