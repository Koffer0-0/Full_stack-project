package com.example.snickersdevops.service.accesscontrol.aspects;

import com.example.snickersdevops.model.User;
import com.example.snickersdevops.service.accesscontrol.AccessControlService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessControlAspectsUser {

	@Autowired
	private AccessControlService<User> accessControlService;

	public void setAccessControlService(AccessControlService<User> accessControlService) {
		this.accessControlService = accessControlService;
	}

	@Around("execution(*  com.example.snickersdevops.repository.UserRepository.save(..)) && args(user)")
	public Object save(ProceedingJoinPoint proceedingJoinPoint, User user) throws Throwable {
		if (user.getId() == null) {
			accessControlService.canCurrentUserCreateObject(user);
		} else {
			accessControlService.canCurrentUserUpdateObject(user);
		}

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(*  com.example.snickersdevops.repository.UserRepository.find(Long)) && args(id)")
	public Object find(ProceedingJoinPoint proceedingJoinPoint, Long id) throws Throwable {
		accessControlService.canCurrentUserReadObject(id);

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(*  com.example.snickersdevops.repository.UserRepository.findAll())")
	public Object findAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		accessControlService.canCurrentUserReadAllObjects();

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(*  com.example.snickersdevops.repository.UserRepository.delete(..)) && args(user)")
	public Object delete(ProceedingJoinPoint proceedingJoinPoint, User user) throws Throwable {
		accessControlService.canCurrentUserDeleteObject(user);

		return proceedingJoinPoint.proceed();
	}
}
