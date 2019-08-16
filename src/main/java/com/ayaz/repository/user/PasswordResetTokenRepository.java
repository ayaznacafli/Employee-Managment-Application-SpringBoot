package com.ayaz.repository.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ayaz.domain.user.PasswordResetToken;
import com.ayaz.domain.user.User;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {

	PasswordResetToken findByToken(String token);
	
	PasswordResetToken findByUser(User user);
	
	@Query("SELECT p FROM PasswordResetToken p WHERE p.expiryDate <= :expiryDate")
	List<PasswordResetToken> findByExpiryDateLessThan(@Param("expiryDate")Date date);
	
	@Query("SELECT p FROM PasswordResetToken p WHERE p.expiryDate <= :expiryDate")
	boolean deleteAllExpiredSince(@Param("expiryDate")Date date);
	
}
