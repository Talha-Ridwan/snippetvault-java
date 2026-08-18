package com.talharidwan.snippetvault.DTOs;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class RefreshTokenResponseDTO {
    private Long id;
    private String token;
    private Timestamp expirationTime;
    private UUID userId;
}
