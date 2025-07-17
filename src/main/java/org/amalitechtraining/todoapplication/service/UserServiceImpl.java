package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.entity.User;
import org.amalitechtraining.todoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userUpdate) {
        var userInDb = userRepository
                .findById(id)
                .orElseThrow();
        mapToUpdate(userInDb,userUpdate);
        return userRepository.save(userInDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository
                .findById(id)
                .orElseThrow();
        userRepository.deleteById(id);
    }

    private void mapToUpdate(User original, User update) {
        original.setFirstName(update.getFirstName());
        original.setLastName(update.getLastName());
        original.setDateOfBirth(update.getDateOfBirth());
    }
}
