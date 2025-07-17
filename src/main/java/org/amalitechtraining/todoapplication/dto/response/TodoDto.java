package org.amalitechtraining.todoapplication.dto.response;


public record TodoDto(
        Long id,
        String title,
        String description,
        String createdAt,
        boolean completed) {
}
