package org.amalitechtraining.todoapplication.mapper;

import org.amalitechtraining.todoapplication.dto.response.TodoDto;
import org.amalitechtraining.todoapplication.entity.Todo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoDtoMapper implements Function<Todo, TodoDto> {
    @Override
    public TodoDto apply(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCreatedAt().toString(),
                todo.isCompleted()
        );
    }
}
