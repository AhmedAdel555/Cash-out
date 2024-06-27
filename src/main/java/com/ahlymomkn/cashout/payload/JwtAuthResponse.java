package com.ahlymomkn.cashout.payload;

public class JwtAuthResponse {
    private String accessToken;
    private final String tokenType ="Bearer";

    private UserDTO userDTO;

    public JwtAuthResponse() {
    }

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
