package com.talharidwan.snippetvault.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "snippets")
public class Snippet {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "snippet")
    private String snippet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user;

    @Column(name="tags")
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> tags;

    @Column(name = "language")
    private String language;
}
