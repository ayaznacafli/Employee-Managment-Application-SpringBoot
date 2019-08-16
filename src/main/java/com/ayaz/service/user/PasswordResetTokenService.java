package com.ayaz.service.user;

import java.util.Date;
import java.util.List;

import com.ayaz.domain.user.PasswordResetToken;
import com.ayaz.domain.user.User;

public interface PasswordResetTokenService {
	

	PasswordResetToken insert(PasswordResetToken passwordResetToken);
	
	PasswordResetToken update(PasswordResetToken passwordResetToken);
	
	PasswordResetToken delete(PasswordResetToken passwordResetToken);
	
	PasswordResetToken getPasswordResetTokenByToken(String token);
	
	PasswordResetToken getPasswordResetTokenByUser(User user);
	
	PasswordResetToken getPasswordResetTokenFindById(Long id);
	
	//vaxti gecen tokenlerin listesini verir
	List<PasswordResetToken> getByExpiryDateLessThan(Date date);
	
	boolean deleteAllExpiredSince(Date date);

}
