package org.amalitechtraining.todoapplication.controller;

import org.amalitechtraining.todoapplication.dto.request.PasswordUpdateRequest;
import org.amalitechtraining.todoapplication.dto.request.UserRequest;
import org.amalitechtraining.todoapplication.dto.response.UserDto;
import org.amalitechtraining.todoapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        var users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        var user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody UserRequest user) {
        var createdUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<User> updateUser(
//            @PathVariable Long id,
//            @RequestBody User user
//    ) {
//        var udpatedUser = userService.updateUser(id,user);
//        return ResponseEntity.ok(udpatedUser);
//    }

    @PutMapping("{id}/password")
    public ResponseEntity<?> updatePassword(
            @PathVariable Long id,
            @RequestBody PasswordUpdateRequest request
    ) {
        userService.updatePassword(id,request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
