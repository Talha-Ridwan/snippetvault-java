package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.RefreshTokenRequestDTO;

import java.util.UUID;

public interface RefreshTokenService {

    UUID resolveUserId(RefreshTokenRequestDTO refreshTokenRequestDTO);

    String generateRefreshToken(UUID userId);
}
