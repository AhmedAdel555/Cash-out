package com.ahlymomkn.cashout.model.entity;

import com.ahlymomkn.cashout.model.enums.Gender;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "users",
        indexes = {
        @Index(name = "idx_national_id", columnList = "nationalId"),
        @Index(name = "idx_username", columnList = "username")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "national_id", unique = true, nullable = false)
    private String nationalId;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mobile_number",unique = true, nullable = false)
    private String mobileNumber;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @OneToMany(mappedBy ="user")
    private List<OTP> optCode;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    public User() {
    }

    public User(String nationalId, String username, String password, String mobileNumber, String imageUrl, Gender gender) {
        this.nationalId = nationalId;
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.imageUrl = imageUrl;
        this.gender = gender;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<OTP> getOptCode() {
        return optCode;
    }

    public void setOptCode(List<OTP> optCode) {
        this.optCode = optCode;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nationalId, user.nationalId) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(mobileNumber, user.mobileNumber) && Objects.equals(imageUrl, user.imageUrl) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nationalId, username, password, mobileNumber, imageUrl, gender);
    }
}
