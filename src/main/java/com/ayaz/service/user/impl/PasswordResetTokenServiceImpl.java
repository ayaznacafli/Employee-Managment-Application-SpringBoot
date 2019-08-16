package com.ayaz.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.user.PasswordResetToken;
import com.ayaz.domain.user.User;
import com.ayaz.repository.user.PasswordResetTokenRepository;
import com.ayaz.service.user.PasswordResetTokenService;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	
	@Override
	public PasswordResetToken insert(PasswordResetToken passwordResetToken) {
		if(passwordResetToken != null) {
			passwordResetTokenRepository.save(passwordResetToken);
			return passwordResetToken;
		}else {
			return null;
		}
	}

	@Override
	public PasswordResetToken update(PasswordResetToken passwordResetToken) {
		if(passwordResetToken != null) {
			passwordResetTokenRepository.save(passwordResetToken);
			return passwordResetToken;
		}else {
			PasswordResetToken updatePasswordResetToken = getPasswordResetTokenByToken(passwordResetToken.getToken());
			passwordResetTokenRepository.save(updatePasswordResetToken);
			return updatePasswordResetToken;
		}
	}

	@Override
	public PasswordResetToken delete(PasswordResetToken passwordResetToken) {
		if(passwordResetToken != null) {
			passwordResetTokenRepository.save(passwordResetToken);
			return passwordResetToken;
		}else {
			PasswordResetToken deletePasswordResetToken = getPasswordResetTokenByToken(passwordResetToken.getToken());
			passwordResetTokenRepository.delete(deletePasswordResetToken);
			return deletePasswordResetToken;
		}
	}

	@Override
	public PasswordResetToken getPasswordResetTokenByToken(String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public PasswordResetToken getPasswordResetTokenByUser(User user) {
		return passwordResetTokenRepository.findByUser(user);
	}

	@Override
	public PasswordResetToken getPasswordResetTokenFindById(Long id) {
		return passwordResetTokenRepository.findById(id).get();
	}

	@Override
	public List<PasswordResetToken> getByExpiryDateLessThan(Date date) {
		return passwordResetTokenRepository.findByExpiryDateLessThan(date);
	}

	@Override
	public boolean deleteAllExpiredSince(Date date) {
		return passwordResetTokenRepository.deleteAllExpiredSince(date);
	}

}
