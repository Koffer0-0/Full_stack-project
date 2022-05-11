package com.example.snickersdevops.repository;

import com.example.snickersdevops.model.ForgotPasswordToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ForgotPasswordTokenRepository extends TokenRepository<ForgotPasswordToken> {
	@Modifying
	@Query("delete from ForgotPasswordToken t where t.expirationDate <= ?1")
	void deletePreviousTo(Date date);
}
