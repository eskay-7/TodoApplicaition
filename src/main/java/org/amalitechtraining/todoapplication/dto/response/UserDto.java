package org.amalitechtraining.todoapplication.dto.response;

import org.amalitechtraining.todoapplication.entity.Gender;


public record UserDto(
        Long id,
        String firstName,
        String lastName,
        Gender gender,
        String dateOfBirth,
        String email) {
}
