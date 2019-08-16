package com.ayaz.service.user.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.user.User;
import com.ayaz.domain.user.VerificationToken;
import com.ayaz.repository.user.VerificationTokenRepository;
import com.ayaz.service.user.UserService;
import com.ayaz.service.user.VerificationTokenService;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired 
	private UserService userService;
	
	private static final String TOKEN_INVALID="invalidToken";
	private static final String TOKEN_EXPIRED="expired";
	private static final String TOKEN_VALID="valid";
	
	
	
	@Override
	public String validateVerificationToken(String token) {
		VerificationToken verificationToken = getVerificationTokenByToken(token);
		if(verificationToken==null) {
			return TOKEN_INVALID;
		}
		
		User user = verificationToken.getUser();
		Calendar calendar = Calendar.getInstance();
		if(verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0) {
			return TOKEN_EXPIRED;
		}
		user.setEnabled(true);
		userService.update(user);
		delete(verificationToken);
		return TOKEN_VALID;
	}

	@Override
	public VerificationToken insert(VerificationToken verificationToken) {
		if(verificationToken != null) {
			verificationTokenRepository.save(verificationToken);
			return verificationToken;
		}else {
			return null;
		}
	}

	@Override
	public VerificationToken update(VerificationToken verificationToken) {
		if(verificationToken != null) {
			verificationTokenRepository.save(verificationToken);
			return verificationToken;
		}else {
			VerificationToken updateVerificationToken = getVerificationTokenByToken(verificationToken.getToken());
			verificationTokenRepository.save(updateVerificationToken);
			return updateVerificationToken;
		}
	}

	@Override
	public VerificationToken delete(VerificationToken verificationToken) {
		if(verificationToken != null) {
			verificationTokenRepository.delete(verificationToken);
			return verificationToken;
		}else {
			VerificationToken deleteVerificationToken = getVerificationTokenByToken(verificationToken.getToken());
			verificationTokenRepository.delete(deleteVerificationToken);
			return deleteVerificationToken;
		}
	}

	@Override
	public VerificationToken getVerificationTokenByToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}

	@Override
	public VerificationToken getVerificationTokenByUser(User user) {
		return verificationTokenRepository.findByUser(user);
	}

	@Override
	public List<VerificationToken> getAllByExpiryDateLessThan(Date date) {
		return verificationTokenRepository.findAllByExpiryDateLessThan(date);
	}

	@Override
	public boolean deleteAllExpiredSince(Date date) {
		return verificationTokenRepository.deleteAllExpiredSince(date);
	}

}
