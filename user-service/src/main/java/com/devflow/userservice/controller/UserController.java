package com.devflow.userservice.controller;

import com.devflow.userservice.dto.UserRequestDto;
import com.devflow.userservice.dto.UserResponseDto;
import com.devflow.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(
            @RequestBody UserRequestDto request) {

        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(
            @PathVariable Long id) {

        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {

        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public UserResponseDto updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto request) {

        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}