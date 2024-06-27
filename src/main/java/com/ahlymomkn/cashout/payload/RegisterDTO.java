package com.ahlymomkn.cashout.payload;

import com.ahlymomkn.cashout.model.enums.Gender;
import jakarta.validation.constraints.*;

public class RegisterDTO {
    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^0[0-9]{10}$", message = "Mobile number must be 11 digits and start with 0")
    private String mobileNumber;

    @NotBlank(message = "National ID is mandatory")
    @Pattern(regexp = "^[0-9]{14}$", message = "National ID must be exactly 14 digits")
    private String nationalId;

    @NotNull(message = "Gender is mandatory")
    private Gender gender;

    @NotBlank(message = "Image URL is mandatory")
    @Pattern(regexp = "^(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|jpeg|gif|png)$", message = "Invalid image URL")
    private String imageUrl;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String password, String mobileNumber, String nationalId, Gender gender, String imageUrl) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.nationalId = nationalId;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
