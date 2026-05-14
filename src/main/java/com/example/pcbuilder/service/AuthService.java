package com.example.pcbuilder.service;

import com.example.pcbuilder.dto.request.LoginRequest;
import com.example.pcbuilder.dto.request.RegisterRequest;
import com.example.pcbuilder.dto.response.AuthResponse;
import com.example.pcbuilder.model.Role;
import com.example.pcbuilder.model.User;
import com.example.pcbuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public ResponseEntity<AuthResponse> registerClient(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(Role.CLIENT)
                .build();
        userRepository.save(newUser);
        String token = jwtService.generateToken(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token, newUser.getEmail(), newUser.getUsername()));
    }

    public ResponseEntity<AuthResponse> registerWorker(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(Role.WORKER)
                .build();
        userRepository.save(newUser);
        String token = jwtService.generateToken(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token, newUser.getEmail(), newUser.getUsername()));
    }

    public ResponseEntity<AuthResponse> registerAdmin(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(Role.ADMIN)
                .build();
        userRepository.save(newUser);
        String token = jwtService.generateToken(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token, newUser.getEmail(), newUser.getUsername()));
    }

    public ResponseEntity<AuthResponse> login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getEmail(), user.getName()));
    }
}
