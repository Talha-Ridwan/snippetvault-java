package com.talharidwan.snippetvault.DTOs;

public record AuthRequestDTO(
        String jwtToken,
        String refreshToken
) {
}
