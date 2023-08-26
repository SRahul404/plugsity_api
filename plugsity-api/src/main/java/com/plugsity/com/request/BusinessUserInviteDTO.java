package com.plugsity.com.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class BusinessUserInviteDTO {

	@NotBlank(message = "BusinessName is required.")
	private String businessName;
	
	@NotBlank(message = "Website url is required.")
	private String website;
	
	@NotEmpty(message = "The email is required.")
	@Email(message = "The email is not a valid email.")
	private String email;
	
	@NotBlank(message = "The phoneNumber is required.")
	private String phoneNumber;
	
	private String address;
	
	private String socialMedia;
	
	@NotBlank(message = "UserRefKey is required.")
	private String userRefKey;
	
	private String message;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	public String getUserRefKey() {
		return userRefKey;
	}

	public void setUserRefKey(String userRefKey) {
		this.userRefKey = userRefKey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
