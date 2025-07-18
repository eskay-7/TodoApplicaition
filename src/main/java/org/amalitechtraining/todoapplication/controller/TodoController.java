package org.amalitechtraining.todoapplication.controller;

import jakarta.validation.Valid;
import org.amalitechtraining.todoapplication.dto.request.TodoRequest;
import org.amalitechtraining.todoapplication.dto.response.TodoDto;
import org.amalitechtraining.todoapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        var todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        var todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody @Valid TodoRequest todo) {
        var createdTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<Todo> updateTodo(
//            @PathVariable Long id,
//            @RequestBody Todo todo
//    ) {
//        var updatedTodo = todoService.markAsCompleted(id,todo);
//        return ResponseEntity.ok(updatedTodo);
//    }

    @PatchMapping ("{id}/complete")
    public ResponseEntity<TodoDto> markAsCompleted(@PathVariable Long id) {
        var updatedTodo = todoService.markAsCompleted(id);
        return ResponseEntity.ok(updatedTodo);
    }

    @PatchMapping ("{id}")
    public ResponseEntity<TodoDto> toggleCompletedStatus(
            @PathVariable Long id,
            @RequestParam(value = "completed") boolean isComplete) {
        var updatedTodo = todoService.toggleCompletedStatus(id,isComplete);
        return ResponseEntity.ok(updatedTodo);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}