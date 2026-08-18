package com.talharidwan.snippetvault.Service;

import java.util.UUID;

public interface RefreshTokenService {
    boolean validateRefreshToken(String token);
    String generateRefreshToken(UUID userId);
}
