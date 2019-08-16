package com.ayaz.task;

import java.time.Instant;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ayaz.service.user.PasswordResetTokenService;
import com.ayaz.service.user.VerificationTokenService;


@Component
public class TokensPugeTask {
	
	private static final Logger LOGGER = LogManager.getLogger(TokensPugeTask.class);

	@Autowired
	private VerificationTokenService verificationTokenService;
	
	@Autowired
	private PasswordResetTokenService passwordResetTokenService;
	
	@Scheduled(cron = "0 0 5 * * ?")
	public void purgeExpired() {
		Date date = Date.from(Instant.now());
		
		passwordResetTokenService.deleteAllExpiredSince(date);
		
		verificationTokenService.deleteAllExpiredSince(date);
		
		
		LOGGER.info("Purge - Expired "  +date);
	}

}
