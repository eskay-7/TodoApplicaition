package org.amalitechtraining.todoapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TodoRequest(
        @NotBlank(message = "Title cannot be empty")
        @Size(min = 2, max = 50, message = "Title must have a length between 2 and 50")
        String title,

        @NotBlank(message = "Description cannot be empty")
        @Size(min = 2, message = "Description must have a min of 2 chars ")
        String description
) {
}
