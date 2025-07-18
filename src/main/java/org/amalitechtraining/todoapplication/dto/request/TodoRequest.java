package org.amalitechtraining.todoapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TodoRequest(
        @NotBlank(message = "title cannot be empty")
        @Size(min = 2, max = 50, message = "title must have a length between 2 and 50 chars")
        String title,

        @NotBlank(message = "description cannot be empty")
        @Size(min = 2, message = "description must have a min of 2 chars ")
        String description
) {
}
