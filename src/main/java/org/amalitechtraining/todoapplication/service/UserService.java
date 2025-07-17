package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.dto.request.PasswordUpdateRequest;
import org.amalitechtraining.todoapplication.dto.request.UserRequest;
import org.amalitechtraining.todoapplication.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUser(Long id);
    UserDto registerUser(UserRequest user);
    void updatePassword (Long id, PasswordUpdateRequest request);
    void deleteUser(Long id);
}
