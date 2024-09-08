package com.jwt.login.dto;

public record LoginResponse(String token, Long expiredIn) {
}
