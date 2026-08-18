package com.talharidwan.snippetvault.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "refresh_tokens")
public class RefreshTokens {
    @Column(name = "id")
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user;

    @Column(name = "token")
    private String token;

    @Column(name = "expiration_time")
    private Timestamp expirationTime;
}
