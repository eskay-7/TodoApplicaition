package org.amalitechtraining.todoapplication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "firstName cannot be empty")
        @Size(min = 2, max = 50, message = "firstName must have a length between 2 and 50")
        String firstName,

        @NotBlank(message = "lastName cannot be empty")
        @Size(min = 2, max = 50, message = "lastName must have a length between 2 and 50")
        String lastName,

        @NotBlank(message = "Gender cannot be empty")
        @Size(min = 4, max = 10, message = "Gender must have a length between 4 and 10")
        @Pattern(regexp = "MALE|FEMALE|OTHER", message = "Gender must be MALE, FEMALE, or OTHER")
        String gender,

        String dateOfBirth,

        @NotBlank(message = "Email cannot be empty")
        @Size(min = 10, max = 50, message = "Email must have a length between 10 and 50")
        @Email(message = "Provide a valid email format")
        String email,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 2, max = 50, message = "Password must have a length between 8 and 50")
        String password) {
}
