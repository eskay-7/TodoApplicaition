package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    User registerUser(User user);
    User updateUser(Long id, User userUpdate);
    void deleteUser(Long id);
}
