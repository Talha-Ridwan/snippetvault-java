package com.talharidwan.snippetvault.Service;

import java.util.UUID;

public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Override
    public boolean validateRefreshToken(String token) {
        // Implement token validation logic here
        return false;
    }

    @Override
    public String generateRefreshToken(UUID userId) {
        // Implement refresh token generation logic here
        return null;
    }

}
