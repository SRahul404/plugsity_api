package com.plugsity.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.plugsity.com.domain.AbstractBaseEntity;

@Entity
@Table(name = "business")
public class BusinessUser extends AbstractBaseEntity{

	@Column(name = "FirstName")
	private String fristName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "BusinessName")
	private String businessName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "Message")
	private String message;
	
	@Column(name = "Token")
	private String token;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	/*
	 * @Column(name = "Created_By") private String createdBy;
	 * 
	 * @Column(name = "Updated_By") private String updatedBy;
	 */

	
}

