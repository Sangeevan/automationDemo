package com.example.unitTestDemo.mapper;

import com.example.unitTestDemo.dto.UserDto;
import com.example.unitTestDemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toEntity(UserDto dto) {
        return new User(dto.getId(), dto.getName(), dto.getAge());
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getAge());
    }
}
