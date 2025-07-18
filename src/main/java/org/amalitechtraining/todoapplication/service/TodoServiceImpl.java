package org.amalitechtraining.todoapplication.service;

import org.amalitechtraining.todoapplication.dto.request.TodoRequest;
import org.amalitechtraining.todoapplication.dto.response.TodoDto;
import org.amalitechtraining.todoapplication.entity.Todo;
import org.amalitechtraining.todoapplication.entity.User;
import org.amalitechtraining.todoapplication.exception.ResourceNotFoundException;
import org.amalitechtraining.todoapplication.mapper.TodoDtoMapper;
import org.amalitechtraining.todoapplication.mapper.TodoRequestMapper;
import org.amalitechtraining.todoapplication.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final TodoDtoMapper dtoMapper;
    private final TodoRequestMapper requestMapper;

    @Autowired
    public TodoServiceImpl(
            TodoRepository todoRepository,
            TodoDtoMapper dtoMapper,
            TodoRequestMapper requestMapper
    ) {
        this.todoRepository = todoRepository;
        this.dtoMapper = dtoMapper;
        this.requestMapper = requestMapper;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(dtoMapper)
                .toList();
    }

    @Override
    public TodoDto getTodo(Long id) {
        return todoRepository
                .findById(id)
                .map(dtoMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Todo with id '%d' not found, check and try again".formatted(id)));
    }

    @Override
    public TodoDto createTodo(TodoRequest todoRequest) {
        var todo = requestMapper.apply(todoRequest);
        var createdUser = todoRepository.save(todo);
        return dtoMapper.apply(createdUser);
    }

    @Override
    public TodoDto markAsCompleted(Long id) {
        var todoInDB = todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Todo with id '%d' not found, check and try again".formatted(id)));
        todoInDB.setCompleted(true);
        return dtoMapper.apply(todoRepository.save(todoInDB));
    }

    @Override
    public TodoDto toggleCompletedStatus(Long id, boolean isComplete) {
        var todoInDB = todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Todo with id '%d' not found, check and try again".formatted(id)));
        todoInDB.setCompleted(isComplete);
        return dtoMapper.apply(todoRepository.save(todoInDB));
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Todo with id '%d' not found, check and try again".formatted(id)));
        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoDto> getUserTodos(User user) {
        return todoRepository
                .findByOwner(user)
                .stream()
                .map(dtoMapper)
                .toList();
    }

    @Override
    public TodoDto createTodoForUser(User user, TodoRequest request) {
        var todo = requestMapper.apply(request);
        user.addTodo(todo);
        return dtoMapper.apply(todoRepository.save(todo));
    }

    private void mapUpdateTodo(Todo original, TodoRequest update) {
        original.setTitle(update.title());
        original.setDescription(update.description());
    }
}
