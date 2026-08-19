package com.talharidwan.snippetvault.Respository;

import com.talharidwan.snippetvault.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    void deleteByGithubId(String githubId);
    Optional<User> findByGithubId(String githubId);
}
