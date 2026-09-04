package com.talharidwan.snippetvault.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefreshTokenRequestDTO {
    // the token the client presents to obtain a new access token
    private String token;
}
