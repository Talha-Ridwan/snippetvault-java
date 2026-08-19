package com.talharidwan.snippetvault.Service;

import com.talharidwan.snippetvault.DTOs.SnippetRequestDTO;
import com.talharidwan.snippetvault.DTOs.SnippetResponseDTO;
import com.talharidwan.snippetvault.Entity.Snippet;
import com.talharidwan.snippetvault.Respository.SnippetRepository;
import com.talharidwan.snippetvault.mapper.SnippetMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SnippetServiceImpl implements SnippetService{
    private final SnippetRepository snippetRepository;

    public SnippetServiceImpl(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }


    @Override
    public SnippetResponseDTO createSnippet(UUID userId, SnippetRequestDTO snippetRequestDTO) {
        Snippet snippet = new Snippet();
        snippet.setUserId(userId);
        snippet.setLanguage(snippetRequestDTO.getLanguage());
        snippet.setSnippet(snippetRequestDTO.getSnippet());
        snippet.setTags(snippetRequestDTO.getTags());
        snippetRepository.save(snippet);
        return SnippetMapper.toResponse(snippet);
    }

    @Override
    public SnippetResponseDTO updateSnippet(SnippetRequestDTO snippetRequestDTO, Long snippetId, UUID userId) {
        Optional<Snippet> snippetOptional = snippetRepository.findByIdAndUserId(snippetId, userId);
        if (snippetOptional.isPresent()) {
            Snippet snippet = snippetOptional.get();
            snippet.setLanguage(snippetRequestDTO.getLanguage());
            snippet.setSnippet(snippetRequestDTO.getSnippet());
            snippet.setTags(snippetRequestDTO.getTags());
            snippetRepository.save(snippet);
            return SnippetMapper.toResponse(snippet);
        } else {
            throw new RuntimeException("Snippet not found or does not belong to the user.");
        }
    }

    @Override
    public void deleteSnippet(SnippetRequestDTO snippetRequestDTO, Long snippetId, UUID userId) {
        Optional<Snippet> snippetOptional = snippetRepository.findByIdAndUserId(snippetId, userId);
        if (snippetOptional.isPresent()) {
            snippetRepository.delete(snippetOptional.get());
        } else {
            throw new RuntimeException("Snippet not found or does not belong to the user.");
        }
    }

    @Override
    public Optional<List<SnippetResponseDTO>> listSnippets(UUID userId) {
        return snippetRepository.findAllByUserId(userId)
                .map(snippets -> snippets.stream()
                        .map(SnippetMapper::toResponse)
                        .toList());
    }
}
