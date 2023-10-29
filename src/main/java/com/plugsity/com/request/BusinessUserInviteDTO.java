package com.plugsity.com.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BusinessUserInviteDTO {

	@NotBlank(message = "BusinessName is required.")
	private String businessName;
	
	@NotNull(message = "Website url is required.")
	private String website;

	@NotNull(message = "The email is required.")
	//@Email(message = "The email is not a valid email.")
	private String email;
	
	@NotNull(message = "The phoneNumber is required.")
	private String phoneNumber;
	
	@NotBlank(message = "UserRefKey is required.")
	private String userRefKey;

	private String countryCode;
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
