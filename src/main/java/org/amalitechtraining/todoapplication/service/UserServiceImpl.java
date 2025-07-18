package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.dto.request.PasswordUpdateRequest;
import org.amalitechtraining.todoapplication.dto.request.TodoRequest;
import org.amalitechtraining.todoapplication.dto.request.UserRequest;
import org.amalitechtraining.todoapplication.dto.response.TodoDto;
import org.amalitechtraining.todoapplication.dto.response.UserDto;
import org.amalitechtraining.todoapplication.entity.User;
import org.amalitechtraining.todoapplication.exception.ResourceNotFoundException;
import org.amalitechtraining.todoapplication.mapper.UserDtoMapper;
import org.amalitechtraining.todoapplication.mapper.UserRequestMapper;
import org.amalitechtraining.todoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoMapper dtoMapper;
    private final UserRequestMapper requestMapper;
    private final TodoService todoService;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            UserDtoMapper dtoMapper,
            UserRequestMapper requestMapper,
            TodoService todoService
    ) {
        this.userRepository = userRepository;
        this.dtoMapper = dtoMapper;
        this.requestMapper = requestMapper;
        this.todoService = todoService;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(dtoMapper)
                .toList();
    }

    @Override
    public UserDto getUser(Long id) {
        return userRepository
                .findById(id)
                .map(dtoMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id '%d' not found, check and try again".formatted(id)));
    }

    @Override
    public UserDto registerUser(UserRequest userRequest) {
        var user = requestMapper.apply(userRequest);
        return dtoMapper.apply(userRepository.save(user));
    }

    @Override
    public void updatePassword(Long id, PasswordUpdateRequest request) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id '%d' not found, check and try again".formatted(id)));

        verifyOldPassword(user,request);
        user.setPassword(request.new_password());
        userRepository.save(user);
    }

//    @Override
//    public UserDto updateUser(Long id, User userUpdate) {
//        var userInDb = userRepository
//                .findById(id)
//                .orElseThrow();
//        mapToUpdate(userInDb,userUpdate);
//        return userRepository.save(userInDb);
//    }

    @Override
    public void deleteUser(Long id) {
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id '%d' not found, check and try again".formatted(id)));
        userRepository.deleteById(id);
    }

    @Override
    public List<TodoDto> getUserTodos(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id '%d' not found, check and try again".formatted(id)));
        return todoService.getUserTodos(user);
    }

    @Override
    public TodoDto createTodo(Long id, TodoRequest request) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id '%d' not found, check and try again".formatted(id)));
        return todoService.createTodoForUser(user, request);
    }

    private void verifyOldPassword (User user, PasswordUpdateRequest request) {
        if (!user.getPassword().equals(request.old_password()))
            throw new IllegalArgumentException("Sorry, you provided the wrong old password");
    }

//    private void mapToUpdate(User original, User update) {
//        original.setFirstName(update.getFirstName());
//        original.setLastName(update.getLastName());
//        original.setDateOfBirth(update.getDateOfBirth());
//    }
}
