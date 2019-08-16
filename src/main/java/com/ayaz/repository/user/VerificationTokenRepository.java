package com.ayaz.repository.user;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ayaz.domain.user.User;
import com.ayaz.domain.user.VerificationToken;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);
	
	VerificationToken findByUser(User user);
	
	@Query("SELECT v FROM VerificationToken v WHERE v.expiryDate <= :expiryDate")
	List<VerificationToken> findAllByExpiryDateLessThan(@Param("expiryDate")Date date);
	
	@Query("DELETE FROM VerificationToken v WHERE v.expiryDate <= :date")
	boolean deleteAllExpiredSince(@Param("date")Date date);
	
	
	
	
	
	
}

