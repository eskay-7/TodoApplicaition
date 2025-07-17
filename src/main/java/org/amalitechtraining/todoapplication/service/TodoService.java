package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.dto.request.TodoRequest;
import org.amalitechtraining.todoapplication.dto.response.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTodos();
    TodoDto getTodo(Long id);
    TodoDto createTodo(TodoRequest todoRequest);
    TodoDto markAsCompleted (Long id);
    void deleteTodo(Long id);
}
