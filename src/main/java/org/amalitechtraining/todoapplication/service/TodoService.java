package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodo(Long id);
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id, Todo todoUpdate);
    void deleteTodo(Long id);
}
