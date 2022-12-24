package com.example.constructionappapi.services.presentationLayer;

import com.example.constructionappapi.services.businessLogicLayer.repositories.AccountRepository;
import com.example.constructionappapi.services.dataAccessLayer.entities.AccountEntity;
import com.example.constructionappapi.services.presentationLayer.bodies.UserInformation;
import com.example.constructionappapi.services.presentationLayer.bodies.AuthenticationRequest;
import com.example.constructionappapi.services.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationAPI {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<UserInformation> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            return Optional.ofNullable(
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())).getPrincipal()).map(AccountEntity.class::cast).map(
                    accountEntity ->
                            ResponseEntity
                                    .status(HttpStatus.OK)
                                    .header("Authorization", "Bearer " + jwtUtils.generateToken(accountEntity))
                                    .body(new UserInformation(
                                            accountEntity.getId(),
                                            accountEntity.getName(),
                                            accountEntity.getEmail(),
                                            accountEntity.getProfileImage(),
                                            accountEntity.getRole())
                                    )).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        /*
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String token = authHeader.substring(7);
            jwtUtils.invalidateToken(token);
        }
        */
        return ResponseEntity.ok("Successfully logged out");
    }
}
