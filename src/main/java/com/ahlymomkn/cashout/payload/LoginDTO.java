package com.ahlymomkn.cashout.payload;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "nationalId is mandatory")
    private String nationalId;

    @NotBlank(message = "password is mandatory")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String nationalId, String password) {
        this.nationalId = nationalId;
        this.password = password;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
