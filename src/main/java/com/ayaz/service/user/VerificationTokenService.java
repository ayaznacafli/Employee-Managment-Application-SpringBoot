package com.ayaz.service.user;

import java.util.Date;
import java.util.List;

import com.ayaz.domain.user.User;
import com.ayaz.domain.user.VerificationToken;

public interface VerificationTokenService {
	
	String validateVerificationToken(String token);
	
	VerificationToken insert(VerificationToken verificationToken);
	
	VerificationToken update(VerificationToken verificationToken);
	
	VerificationToken delete(VerificationToken verificationToken);
	
	VerificationToken getVerificationTokenByToken(String token);
	
	VerificationToken getVerificationTokenByUser(User user);
	
	//vaxti gecen tokenlerin listesini verir
	List<VerificationToken> getAllByExpiryDateLessThan(Date date);
	
	
	boolean deleteAllExpiredSince(Date date);
}
