package com.example.snickersdevops.service.accesscontrol;

import com.example.snickersdevops.exceptions.*;
import com.example.snickersdevops.model.*;
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
