package com.example.unitTestDemo.mapper;

import com.example.unitTestDemo.dto.UserDto;
import com.example.unitTestDemo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {
    private final UserMapper mapper = new UserMapper();

    @Test
    void testToEntity() {
        UserDto dto = new UserDto(1L, "John", 25);

        User user = mapper.toEntity(dto);

        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());
        assertEquals(25, user.getAge());
    }

    @Test
    void testToDto() {
        User user = new User(2L, "Alice", 30);

        UserDto dto = mapper.toDto(user);

        assertNotNull(dto);
        assertEquals(2L, dto.getId());
        assertEquals("Alice", dto.getName());
        assertEquals(30, dto.getAge());
    }
}
