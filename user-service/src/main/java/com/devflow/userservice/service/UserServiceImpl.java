package com.devflow.userservice.service;

import com.devflow.userservice.dto.UserRequestDto;
import com.devflow.userservice.dto.UserResponseDto;
import com.devflow.userservice.entity.UserEntity;
import com.devflow.userservice.exception.ResourceNotFoundException;
import com.devflow.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto request) {

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .username(request.getUsername())
                .build();

        return map(userRepository.save(user));
    }

    @Override
    public UserResponseDto getUser(Long id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return map(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }
    @Override
    public UserResponseDto updateUser(Long id,
                                      UserRequestDto request) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());

        return map(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        userRepository.delete(user);
    }

    private UserResponseDto map(UserEntity user) {

        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}