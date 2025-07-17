package org.amalitechtraining.todoapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordUpdateRequest (

        @NotBlank(message = "Old password field cannot be empty")
        @Size(min = 8, max = 50, message = "Password must have a length between 8 and 50")
        String oldPassword,

        @NotBlank(message = "New password field cannot be empty")
        @Size(min = 8, max = 50, message = "Password must have a length between 8 and 50")
        String newPassword
) {
}
