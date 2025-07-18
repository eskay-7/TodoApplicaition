package org.amalitechtraining.todoapplication.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRequest(
        @NotBlank(message = "first_name field cannot be empty")
        @Size(min = 2, max = 50, message = "first_name must have a length between 2 and 50 chars")
        String first_name,

        @Size(min = 2, max = 50, message = "last_name must have a length between 2 and 50 chars")
        @NotBlank(message = "last_name field cannot be empty")
        String last_name,

        @NotBlank(message = "gender field cannot be empty")
        @Size(min = 4, max = 10, message = "gender must have a length between 4 and 10 chars")
        @Pattern(regexp = "MALE|FEMALE|OTHER", message = "gender must be MALE, FEMALE, or OTHER")
        String gender,

//        @Past(message = "date_of_birth value must be a past date")
        @Past
        LocalDate date_of_birth,

        @NotBlank(message = "email field cannot be empty")
        @Size(min = 10, max = 50, message = "email must have a length between 10 and 50 chars")
        @Email(message = "please provide a valid email format")
        String email,

        @NotBlank(message = "password field cannot be empty")
        @Size(min = 2, max = 50, message = "password must have a length between 8 and 50 chars")
        String password) {
}
