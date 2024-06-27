package com.ahlymomkn.cashout.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class NotificationRequestDTO {

    @NotBlank(message = "National ID is mandatory")
    @Pattern(regexp = "^[0-9]{14}$", message = "National ID must be exactly 14 digits")
    private String nationalId;

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "body is mandatory")
    private String body;

    public NotificationRequestDTO() {
    }

    public NotificationRequestDTO(String nationalId, String title, String body) {
        this.nationalId = nationalId;
        this.title = title;
        this.body = body;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
