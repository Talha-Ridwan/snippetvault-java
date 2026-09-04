package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.RefreshTokenRequestDTO;
import com.talharidwan.snippetvault.Entity.RefreshTokens;
import com.talharidwan.snippetvault.Respository.RefreshTokenRepository;
import com.talharidwan.snippetvault.Respository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UUID resolveUserId(RefreshTokenRequestDTO refreshTokenRequestDTO) {
        RefreshTokens curToken = refreshTokenRepository.findByToken(refreshTokenRequestDTO.getToken()).orElse(null);
        if (curToken == null ||
                curToken.getExpirationTime().before(Timestamp.valueOf(java.time.LocalDateTime.now()))) {
            return null;
        }
        return curToken.getUser().getId();
    }

    @Override
    public String generateRefreshToken(UUID userId) {
        String newToken = UUID.randomUUID().toString();
        RefreshTokens refreshToken = new RefreshTokens();
        refreshToken.setToken(newToken);
        refreshToken.setUser(userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
        refreshToken.setExpirationTime(Timestamp.valueOf(java.time.LocalDateTime.now().plusDays(7)));
        refreshTokenRepository.save(refreshToken);
        return newToken;
    }

}
