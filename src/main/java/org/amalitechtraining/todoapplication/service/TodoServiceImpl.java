package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.entity.Todo;
import org.amalitechtraining.todoapplication.repository.TodoRepository;

import java.util.List;

public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodo(Long id) {
        return todoRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todoUpdate) {
        var todoInDB = todoRepository
                .findById(id)
                .orElseThrow();
        mapUpdateTodo(todoInDB, todoUpdate);
        return todoRepository.save(todoInDB);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository
                .findById(id)
                .orElseThrow();
        todoRepository.deleteById(id);
    }

    private void mapUpdateTodo(Todo original, Todo update) {
        original.setTitle(update.getTitle());
        original.setDescription(update.getDescription());
        original.setCompleted(update.isCompleted());
    }
}
