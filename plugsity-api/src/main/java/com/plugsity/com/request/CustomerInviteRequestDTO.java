package com.plugsity.com.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

public class CustomerInviteRequestDTO {

	@NotBlank(message = "The fristName is required.")
	private String fristName;
	
	@NotBlank(message = "The lastName is required.")
	private String lastName;
	
	@NotEmpty(message = "The email is required.")
	@Email(message = "The email is not a valid email.")
	private String email;
	
	@NotBlank(message = "The phoneNumber is required.")
	private String phoneNumber;
	
	@NotBlank(message = "UserRefKey is required.")
	private String userRefKey;
	
	@NotNull(message = "zipCode can't be null")
	private String zipCode;

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
