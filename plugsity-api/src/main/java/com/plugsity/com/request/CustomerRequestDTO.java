package com.plugsity.com.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerRequestDTO {

	@NotBlank(message = "The fristName is required.")
	private String fristName;
	
	@NotBlank(message = "The lastName is required.")
	private String lastName;
	
	@NotEmpty(message = "The email is required.")
	@Email(message = "The email is not a valid email.")
	private String email;
	
	@NotBlank(message = "The phoneNumber is required.")
	private String phoneNumber;
	
	@NotNull(message = "Message can't be null")
	private String message;
}
