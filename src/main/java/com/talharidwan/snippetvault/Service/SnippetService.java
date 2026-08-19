package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.SnippetRequestDTO;
import com.talharidwan.snippetvault.DTOs.SnippetResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SnippetService {
    SnippetResponseDTO createSnippet(UUID userId, SnippetRequestDTO snippetRequestDTO);
    SnippetResponseDTO updateSnippet(SnippetRequestDTO snippetRequestDTO, Long id, UUID userId);
    void deleteSnippet(SnippetRequestDTO snippetRequestDTO, Long id, UUID userId);
    Optional<List<SnippetResponseDTO>> listSnippets(UUID userId);
}
