package com.example.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.dto.CreateUserRequest;
import com.example.dto.UserResponse;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    @Transactional
    public UserResponse createUser(CreateUserRequest req) {
        userRepository.findByEmail(req.email()).ifPresent(u -> {
            throw new IllegalStateException("Email already in use");
        });

        User saved = userRepository.save(
                User.builder()
                        .name(req.name())
                        .email(req.email())
                        .build()
        );

        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

}
