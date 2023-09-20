package com.plugsity.com.request;

import javax.validation.constraints.NotBlank;

public class GetInfoDTO {

    @NotBlank(message = "Token is required.")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
