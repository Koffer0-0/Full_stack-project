package com.example.snickersdevops.service.accesscontrol.aspects;

import jorge.rv.quizzz.model.BaseModel;
import org.aspectj.lang.ProceedingJoinPoint;

public interface AccessControlAspects<T extends BaseModel> {
	Object save(ProceedingJoinPoint proceedingJoinPoint, T object) throws Throwable;

	Object find(ProceedingJoinPoint proceedingJoinPoint, Long id) throws Throwable;

	Object findAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable;

	Object delete(ProceedingJoinPoint proceedingJoinPoint, T object) throws Throwable;
}