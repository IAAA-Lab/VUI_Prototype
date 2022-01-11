package com.example.demo;

public class AnswerNotFoundException extends RuntimeException {
    public AnswerNotFoundException(Long id) {
        super("Could not find answer "+ id);
    }
}
