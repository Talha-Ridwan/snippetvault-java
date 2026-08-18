package com.talharidwan.snippetvault.DTOs;
import com.talharidwan.snippetvault.Entity.Snippet;
import lombok.Data;

import java.util.List;

@Data
public class SnippetRequestDTO {
    private List<String> tags;
    private String language;
    private String snippet;
}
