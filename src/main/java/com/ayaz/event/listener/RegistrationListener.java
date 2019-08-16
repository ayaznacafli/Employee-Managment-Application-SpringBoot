package com.ayaz.event.listener;

import java.util.Locale;
import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.ayaz.domain.user.User;
import com.ayaz.domain.user.VerificationToken;
import com.ayaz.event.OnRegistrationCompleteEvent;
import com.ayaz.event.listener.util.StatusRegistration;
import com.ayaz.service.user.VerificationTokenService;


@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private VerificationTokenService verificationTokenService;;

	@Autowired
	private Environment environment;

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		if (StatusRegistration.isStatus()) {
			this.confirmRegistration(event);
			StatusRegistration.setStatus(false);
		}
	}

	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		String appUrl = event.getAppUrl();
		User user = event.getUser();
		Locale locale = event.getLocale();
		String token = UUID.randomUUID().toString();

		VerificationToken verificationToken = new VerificationToken(token, user);

		verificationTokenService.insert(verificationToken);
		
		String email = event.getUser().getEmail();
		String subject = messageSource.getMessage("message.registration.confirm.subject",null, locale);
		String text = messageSource.getMessage("message.registration.confirm.text",null, locale);
			   text += "\n" + appUrl + "/users/registrationConfirm?token=" + token; 													

		SimpleMailMessage mailMessage = createEmailContains(subject, text, email);
		
		javaMailSender.send(mailMessage);
	}

	private SimpleMailMessage createEmailContains(String subject, String text, String email) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setText(text);
		mailMessage.setSubject(subject);
		mailMessage.setTo(email);
		mailMessage.setFrom(environment.getProperty("support.email"));
		return mailMessage;
	}

}
