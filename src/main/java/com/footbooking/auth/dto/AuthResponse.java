package com.footbooking.auth.dto;

public record AuthResponse (

        String accessToken,
        String refreshToken
){
}
