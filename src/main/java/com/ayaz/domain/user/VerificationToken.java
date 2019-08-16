package com.ayaz.domain.user;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class VerificationToken {

	@Transient
	private final int EXPIRY_DATE = 60*24;
	//@Transient olan property veritaban�na yans�maz
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "verificationTokenId")
	private Long id;
	
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name="userId")
	private User user;
	
	@Column(length=60)
	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	
	public VerificationToken() {
		this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
	}
	
	public VerificationToken(String token, User user) {
		this.token = token;
		this.user = user;
		this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
		
	}
		
	
	
	private Date calculateExpiryDate(int EXPIRY_DATE) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTimeInMillis(new Date().getTime()); 
		calendar.add(Calendar.MINUTE, EXPIRY_DATE); 
		return new Date(calendar.getTime().getTime());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}
