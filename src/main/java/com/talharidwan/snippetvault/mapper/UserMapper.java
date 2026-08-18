package com.talharidwan.snippetvault.mapper;


import com.talharidwan.snippetvault.DTOs.UserRequestDTO;
import com.talharidwan.snippetvault.DTOs.UserResponseDTO;
import com.talharidwan.snippetvault.Entity.User;

public class UserMapper {
    public static UserResponseDTO toResponse(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setAvatarUrl(user.getAvatarUrl());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setId(user.getId());

        return userResponseDTO;
    }

    public static UserRequestDTO toRequest(User user){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername(user.getUsername());
        userRequestDTO.setAvatarUrl(user.getAvatarUrl());
        userRequestDTO.setName(user.getName());

        return userRequestDTO;
    }
}
