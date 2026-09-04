package com.talharidwan.snippetvault.Respository;

import com.talharidwan.snippetvault.Entity.RefreshTokens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokens, UUID> {
    Optional<RefreshTokens> findByToken(String token);
}
