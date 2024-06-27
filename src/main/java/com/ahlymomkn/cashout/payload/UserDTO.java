package com.ahlymomkn.cashout.payload;

public class UserDTO {
    private Integer id;

    private String nationalId;

    private String username;

    private String mobileNumber;

    private String imageUrl;

    public UserDTO() {
    }

    public UserDTO(Integer id, String nationalId, String username, String mobileNumber, String imageUrl) {
        this.id = id;
        this.nationalId = nationalId;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
