package com.talharidwan.snippetvault.DTOs;

import lombok.Data;

@Data
public class RefreshTokenRequestDTO {
    // the token the client presents to obtain a new access token
    private String token;
}
