package com.talharidwan.snippetvault.DTOs;

public record AuthResponseDTO(
        String jwtToken,
        String refreshToken
) {

}
