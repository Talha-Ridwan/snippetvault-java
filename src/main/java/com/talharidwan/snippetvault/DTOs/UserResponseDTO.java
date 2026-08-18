package com.talharidwan.snippetvault.DTOs;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {
    private UUID id;
    private String username;
    private String avatarUrl;
    private String name;
}
