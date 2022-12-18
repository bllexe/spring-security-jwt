package com.tigris.springsecurityjwt.modal;

import lombok.Data;

@Data
public class AuthResponse {

    Long userId;
    String accessToken;
    String refreshToken;
    String message;
}
