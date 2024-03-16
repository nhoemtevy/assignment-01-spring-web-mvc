package com.example.spring.service;

import com.example.spring.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoServiceImpl implements TodoService{
    private List<Todo> todoList = new ArrayList<>();
    public List<Todo> getAllTodos() {
        return todoList;
    }
    public Todo getTodoById(Long id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
    }
    public Todo addTodo(Todo todo) {
        todoList.add(todo);
        return todo;
    }
    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);
        todo.setTask(todoDetails.getTask());
        todo.setDescription(todoDetails.getDescription());
        todo.setCreatedAt(todoDetails.getCreatedAt());
        todo.setDone(todoDetails.isDone());
        return todo;
    }
    public void deleteTodoById(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }


}
