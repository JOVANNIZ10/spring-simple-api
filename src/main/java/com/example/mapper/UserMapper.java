package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import com.example.dto.UserResponse;
import com.example.model.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;
    public UserResponse toBookResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
