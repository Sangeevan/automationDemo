package com.example.unitTestDemo.controller;

import com.example.unitTestDemo.dto.UserDto;
import com.example.unitTestDemo.mapper.UserMapper;
import com.example.unitTestDemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User API", description = "Operations related to users")
public class UserController {
    private final UserService service;
    private final UserMapper userMapper;

    public UserController(UserService service, UserMapper userMapper) {
        this.service = service;
        this.userMapper = userMapper;
    }

    @GetMapping("/name/{id}")
    @Operation(summary = "Get user name by ID")
    public String getUserName(@PathVariable Long id) {
        return service.getUserName(id);
    }

    @GetMapping("/get")
    @Operation(summary = "Get user by ID")
    public UserDto getUser(@RequestParam Long id) {
        return userMapper.toDto(service.getUser(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Create user")
    public UserDto createUser(@RequestBody UserDto user) {
        return userMapper.toDto(service.saveUser(userMapper.toEntity(user)));
    }
}
