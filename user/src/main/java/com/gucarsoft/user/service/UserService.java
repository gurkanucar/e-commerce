package com.gucarsoft.user.service;

import com.gucarsoft.user.dto.CreateUserRequest;
import com.gucarsoft.user.dto.UpdateUserRequest;
import com.gucarsoft.user.dto.UserDto;
import com.gucarsoft.user.dto.converter.UserDtoConverter;
import com.gucarsoft.user.exception.UserNotFoundException;
import com.gucarsoft.user.model.User;
import com.gucarsoft.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user couldn't be found by following id: " + id));
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User(
                null,
                userRequest.getMail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getMiddleName());

        return userDtoConverter.convert(user);
    }


    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);
        User updateUser = new User(
                user.getId(),
                updateUserRequest.getMail(),
                updateUserRequest.getFirstName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName());

        return userDtoConverter.convert(userRepository.save(updateUser));
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user couldn't be found by following id: " + id));

    }
}
