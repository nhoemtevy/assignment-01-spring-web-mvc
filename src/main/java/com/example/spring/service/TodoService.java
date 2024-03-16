package com.example.spring.service;

import com.example.spring.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    Todo addTodo(Todo todo);
    Todo updateTodo(Long id, Todo todoDetails);
    void deleteTodoById(Long id);
}
