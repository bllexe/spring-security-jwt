package com.tigris.springsecurityjwt.modal;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    Long userId;
    String refreshToken;
}
