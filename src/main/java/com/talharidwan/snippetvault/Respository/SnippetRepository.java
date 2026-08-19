package com.talharidwan.snippetvault.Respository;

import com.talharidwan.snippetvault.Entity.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SnippetRepository extends JpaRepository<Snippet, Integer> {
    List<Snippet> findAllByUserId(UUID userId);
}