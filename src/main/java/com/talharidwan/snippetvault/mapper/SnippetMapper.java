package com.talharidwan.snippetvault.mapper;

import com.talharidwan.snippetvault.DTOs.SnippetRequestDTO;
import com.talharidwan.snippetvault.DTOs.SnippetResponseDTO;
import com.talharidwan.snippetvault.Entity.Snippet;
import com.talharidwan.snippetvault.Entity.User;

import java.util.List;

public class SnippetMapper {

    // entity -> response
    public static SnippetResponseDTO toResponse(Snippet snippet) {
        if (snippet == null) return null;
        SnippetResponseDTO dto = new SnippetResponseDTO();
        dto.setId(snippet.getId());
        dto.setSnippet(snippet.getSnippet());
        dto.setTags(snippet.getTags());
        dto.setLanguage(snippet.getLanguage());
        dto.setUserResponseDTO(UserMapper.toResponse(snippet.getUser()));
        return dto;
    }

    // request -> entity (user set separately from the authenticated principal)
    public static Snippet toEntity(SnippetRequestDTO dto, User owner) {
        if (dto == null) return null;
        Snippet snippet = new Snippet();
        snippet.setSnippet(dto.getSnippet());
        snippet.setTags(dto.getTags());
        snippet.setLanguage(dto.getLanguage());
        snippet.setUser(owner);
        return snippet;
    }

    public static List<SnippetResponseDTO> toResponseList(List<Snippet> snippets) {
        return snippets.stream().map(SnippetMapper::toResponse).toList();
    }
}
