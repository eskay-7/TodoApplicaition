package org.amalitechtraining.todoapplication.mapper;

import org.amalitechtraining.todoapplication.dto.request.UserRequest;
import org.amalitechtraining.todoapplication.entity.Gender;
import org.amalitechtraining.todoapplication.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
public class UserRequestMapper implements Function<UserRequest, User> {
    @Override
    public User apply(UserRequest userRequest) {
         return User.builder()
                    .firstName(userRequest.firstName())
                    .lastName(userRequest.lastName())
                    .gender(Gender.valueOf(
                            userRequest.gender().toUpperCase()))
                    .dateOfBirth(LocalDate.parse(userRequest.dateOfBirth()))
                    .email(userRequest.email())
                    .password(userRequest.password())
                    .build();
    }
}
