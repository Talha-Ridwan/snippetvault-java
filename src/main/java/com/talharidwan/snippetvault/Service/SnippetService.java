package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.SnippetRequestDTO;
import com.talharidwan.snippetvault.DTOs.SnippetResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SnippetService {
    SnippetResponseDTO createSnippet(SnippetRequestDTO snippetRequestDTO);
    SnippetResponseDTO updateSnippet(SnippetRequestDTO snippetRequestDTO);
    void deleteSnippet(SnippetRequestDTO snippetRequestDTO);
    List<SnippetResponseDTO> listSnippets(UUID userId);
}
