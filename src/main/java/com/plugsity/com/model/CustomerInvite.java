package com.plugsity.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.plugsity.com.domain.AbstractBaseEntity;

@Entity
@Table(name = "customer_invite")
public class CustomerInvite extends AbstractBaseEntity{

	@Column(name = "FirstName",nullable=false)
	private String firstName;
	
	@Column(name = "LastName",nullable=false)
	private String lastName;
	
	@Column(name = "Email",nullable=false)
	private String email;
	
	@Column(name = "PhoneNumber",nullable=false)
	private String phoneNumber;

	@Column(name = "UserRefKey",nullable=false)
	private String userRefKey;
	
	@Column(name = "Token",nullable=false)
	private String token;

	@Column(name = "CountryCode")
	private String countryCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserRefKey() {
		return userRefKey;
	}

	public void setUserRefKey(String userRefKey) {
		this.userRefKey = userRefKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
