package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.dto.request.TodoRequest;
import org.amalitechtraining.todoapplication.dto.response.TodoDto;
import org.amalitechtraining.todoapplication.entity.User;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTodos();
    TodoDto getTodo(Long id);
    TodoDto createTodo(TodoRequest todoRequest);
    TodoDto markAsCompleted (Long id);

    TodoDto toggleCompletedStatus(Long id, boolean isComplete);

    void deleteTodo(Long id);
    List<TodoDto> getUserTodos(User user);

    TodoDto createTodoForUser(User user, TodoRequest request);
}
