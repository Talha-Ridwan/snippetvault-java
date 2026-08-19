package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.UserRequestDTO;
import com.talharidwan.snippetvault.DTOs.UserResponseDTO;
import com.talharidwan.snippetvault.Entity.User;
import com.talharidwan.snippetvault.Respository.UserRepository;
import com.talharidwan.snippetvault.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO resolveGitHubUser(UserRequestDTO userRequestDTO) {
        // Implementation for resolving GitHub user
        return UserMapper.toResponse(createOrResolveUser(userRequestDTO));
    }

    private User createOrResolveUser(UserRequestDTO userRequestDTO) {
        Optional<User> userExist =  userRepository.findByGithubId(userRequestDTO.getGithubId());
        return userExist.map(user -> updatedUserDetails(user, userRequestDTO)).orElseGet(() -> createUser(userRequestDTO));
    }

    private User updatedUserDetails(User user, UserRequestDTO userRequestDTO) {
        user.setName(userRequestDTO.getName());
        user.setAvatarUrl(userRequestDTO.getAvatarUrl());
        user.setUsername(userRequestDTO.getUsername());
        userRepository.save(user);
        return user;
    }

    private User createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setGithubId(userRequestDTO.getGithubId());
        user.setUsername(userRequestDTO.getUsername());
        user.setAvatarUrl(userRequestDTO.getAvatarUrl());
        user.setName(userRequestDTO.getName());
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteByGithubId(id);
    }
}
