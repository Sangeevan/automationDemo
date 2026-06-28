package com.example.unitTestDemo.controller;

import com.example.unitTestDemo.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class UserControllerIT {
    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void testGetUserName() {
        restTestClient.get()
                .uri("http://localhost:%d/user/name/1".formatted(port))
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Sangeevan");
    }

    @Test
    void testGetUser() {
        restTestClient.get()
                .uri("http://localhost:%d/user/get?id=1".formatted(port))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testAddUser() {
        restTestClient.post()
                .uri("http://localhost:%d/user/add".formatted(port))
                .body(new UserDto(101L, "Sangeevan101", 101))
                .exchange()
                .expectStatus().isOk();
    }
}
