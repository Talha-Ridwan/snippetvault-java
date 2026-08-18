package com.talharidwan.snippetvault.DTOs;

import com.talharidwan.snippetvault.Entity.User;
import lombok.Data;

import java.util.List;

@Data
public class SnippetResponseDTO {
    private Long id;
    private String snippet;
    private UserResponseDTO userResponseDTO;
    private List<String> tags;
    private String language;
}
