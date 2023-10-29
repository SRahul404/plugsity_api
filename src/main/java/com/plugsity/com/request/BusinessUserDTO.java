package com.plugsity.com.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class BusinessUserDTO {

	@NotBlank(message = "The firstname is required.")
	private String firstName;
	
	@NotBlank(message = "The lastName is required.")
	private String lastName;
	
	@NotBlank(message = "The businessName is required.")
	private String businessName;
	
	@NotEmpty(message = "The email is required.")
	@Email(message = "The email is not a valid email.")
	private String email;
	
	@NotBlank(message = "The phoneNumber is required.")
	private String phoneNumber;
	
	@NotNull(message = "Message can't be null")
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
