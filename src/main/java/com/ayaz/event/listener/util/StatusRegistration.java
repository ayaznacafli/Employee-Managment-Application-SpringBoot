package com.ayaz.event.listener.util;

import org.springframework.stereotype.Component;

@Component
public class StatusRegistration {
	
	private static boolean status = true;

	public static boolean isStatus() {
		return status;
	}

	public static void setStatus(boolean status) {
		StatusRegistration.status = status;
	}

}
