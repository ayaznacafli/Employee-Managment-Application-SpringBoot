package com.ayaz.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.ayaz.domain.user.User;
import com.ayaz.event.listener.util.StatusRegistration;



public class OnRegistrationCompleteEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	private String appUrl;
	
	private User user;
	
	private Locale locale;

	public OnRegistrationCompleteEvent(String appUrl, User user, Locale locale) {
		super(user);
		StatusRegistration.setStatus(true);
		this.appUrl = appUrl;
		this.user = user;
		this.locale = locale;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
