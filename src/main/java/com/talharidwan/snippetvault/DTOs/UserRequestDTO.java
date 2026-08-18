package com.talharidwan.snippetvault.DTOs;
import com.talharidwan.snippetvault.Entity.User;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRequestDTO {
    private String username;
    private String githubId;
    private String email;
    private String avatarUrl;
    private String name;
}
