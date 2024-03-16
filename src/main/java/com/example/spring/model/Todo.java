package com.example.spring.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Todo {
    private static long nextId = 1;
    private Long id;
    private String task;
    private String description;
    private LocalDate createdAt;
    private boolean isDone;
    public Todo() {
        this.id = nextId++;
        this.createdAt = LocalDate.now();
    }
}
