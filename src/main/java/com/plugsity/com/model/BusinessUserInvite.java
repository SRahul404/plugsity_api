package com.plugsity.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.plugsity.com.domain.AbstractBaseEntity;

@Entity
@Table(name = "business_invite")
public class BusinessUserInvite extends AbstractBaseEntity{

	@Column(name = "BusinessName",nullable=false)
	private String businessName;

	@Column(name = "Email",nullable=false)
	private String email;
	
	@Column(name = "PhoneNumber",nullable=false)
	private String phoneNumber;

	@Column(name = "Token",nullable=false)
	private String token;
	
	@Column(name = "UserRefKey",nullable=false)
	private String userRefKey;

	@Column(name = "Website",nullable=false)
	private String website;

	@Column(name = "CountryCode")
	private String countryCode;
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserRefKey() {
		return userRefKey;
	}

	public void setUserRefKey(String userRefKey) {
		this.userRefKey = userRefKey;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
