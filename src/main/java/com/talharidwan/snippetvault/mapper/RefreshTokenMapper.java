package com.talharidwan.snippetvault.mapper;

import com.talharidwan.snippetvault.DTOs.RefreshTokenResponseDTO;
import com.talharidwan.snippetvault.Entity.RefreshTokens;

public class RefreshTokenMapper {

    // entity -> response
    public static RefreshTokenResponseDTO toResponse(RefreshTokens token) {
        if (token == null) return null;
        RefreshTokenResponseDTO dto = new RefreshTokenResponseDTO();
        dto.setId(token.getId());
        dto.setToken(token.getToken());
        dto.setExpirationTime(token.getExpirationTime());
        if (token.getUser() != null) {
            dto.setUserId(token.getUser().getId());
        }
        return dto;
    }
}
