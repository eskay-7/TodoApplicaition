package org.amalitechtraining.todoapplication.mapper;

import org.amalitechtraining.todoapplication.dto.response.UserDto;
import org.amalitechtraining.todoapplication.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDtoMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getDateOfBirth().toString(),
                user.getEmail()
        );
    }
}
