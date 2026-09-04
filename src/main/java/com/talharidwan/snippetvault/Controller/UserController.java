package com.talharidwan.snippetvault.Controller;

import com.talharidwan.snippetvault.DTOs.*;
import com.talharidwan.snippetvault.Service.RefreshTokenService;
import com.talharidwan.snippetvault.Service.UserService;
import com.talharidwan.snippetvault.Utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtil jwtUtil;
    public UserController(UserService userService, RefreshTokenService refreshTokenService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.refreshTokenService = refreshTokenService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> handleLogin(@Validated @RequestBody AuthRequestDTO authRequestDTO) {
        // access token still valid -> hand it back unchanged
        if(jwtUtil.validateToken(authRequestDTO.jwtToken())) {
            return ResponseEntity.ok(new AuthResponseDTO(authRequestDTO.jwtToken(), authRequestDTO.refreshToken()));
        }
        // access token expired -> mint a new one, deriving the user from the
        // refresh token itself (identity is never taken from the request body)
        UUID userId = refreshTokenService.resolveUserId(new RefreshTokenRequestDTO(authRequestDTO.refreshToken()));
        if(userId != null) {
            String newJwtToken = jwtUtil.generateToken(userId.toString());
            return ResponseEntity.ok(new AuthResponseDTO(newJwtToken, authRequestDTO.refreshToken()));
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping("/github/callback")
    public ResponseEntity<AuthResponseDTO> handleGithubCallback(@Validated @RequestBody UserRequestDTO userRequestDTO) {
        // first login: server creates/resolves the user (id is generated on save),
        // then issues the initial access + refresh tokens for that id
        UserResponseDTO user = userService.resolveGitHubUser(userRequestDTO);
        String jwtToken = jwtUtil.generateToken(user.getId().toString());
        String refreshToken = refreshTokenService.generateRefreshToken(user.getId());
        return ResponseEntity.ok(new AuthResponseDTO(jwtToken, refreshToken));
    }
}
