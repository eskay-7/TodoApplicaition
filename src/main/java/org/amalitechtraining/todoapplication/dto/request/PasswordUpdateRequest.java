package org.amalitechtraining.todoapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordUpdateRequest (

        @NotBlank(message = "old_password field cannot be empty")
        @Size(min = 8, max = 50, message = "old_password must have a length between 8 and 50 chars")
        String old_password,

        @NotBlank(message = "new_password field cannot be empty")
        @Size(min = 8, max = 50, message = "new_password must have a length between 8 and 50 chars")
        String new_password
) {
}
