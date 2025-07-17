package org.amalitechtraining.todoapplication.mapper;

import org.amalitechtraining.todoapplication.dto.request.TodoRequest;
import org.amalitechtraining.todoapplication.entity.Todo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
public class TodoRequestMapper implements Function<TodoRequest, Todo> {
    @Override
    public Todo apply(TodoRequest todoRequest) {
        return Todo.builder()
                .title(todoRequest.title())
                .description(todoRequest.description())
                .createdAt(LocalDate.now())
                .completed(false)
                .build();
    }
}
