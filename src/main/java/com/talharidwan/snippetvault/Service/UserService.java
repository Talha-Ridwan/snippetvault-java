package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.UserRequestDTO;
import com.talharidwan.snippetvault.Entity.User;

public interface UserService {
    User resolveGitHubUser(UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
}
