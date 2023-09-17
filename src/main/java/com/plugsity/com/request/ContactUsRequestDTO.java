package com.plugsity.com.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContactUsRequestDTO {

    @NotBlank(message = "The firstName is required.")
    private String firstName;

    @NotBlank(message = "The lastName is required.")
    private String lastName;

    @NotEmpty(message = "The email is required.")
    @Email(message = "The email is not a valid email.")
    private String email;

    @NotNull(message = "Subject can't be null")
    private String subject;

    @NotBlank(message = "Message is required.")
    private String message;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
