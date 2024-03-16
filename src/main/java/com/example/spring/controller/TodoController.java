package com.example.spring.controller;

import com.example.spring.model.Todo;
import com.example.spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("todoList", todoService.getAllTodos());
        return "index";
    }

    @GetMapping("/add")
    public String addTodo() {
        return "create";
    }

    @PostMapping("/add")
    public String addTodo(Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        return "edit";
    }
    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable("id") Long id, Todo todoDetails) {
        todoService.updateTodo(id, todoDetails);
        return "redirect:/";
    }
    @GetMapping("view/{id}")
    public String viewTodo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        return "view";
    }
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }
}
