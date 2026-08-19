package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.UserRequestDTO;
import com.talharidwan.snippetvault.DTOs.UserResponseDTO;
import com.talharidwan.snippetvault.Entity.User;

public interface UserService {
    UserResponseDTO resolveGitHubUser(UserRequestDTO userRequestDTO);
    void deleteUser(String id);
}
