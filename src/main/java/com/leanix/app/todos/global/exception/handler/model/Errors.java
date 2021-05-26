package com.leanix.app.todos.global.exception.handler.model;

import lombok.Data;

import java.util.List;

@Data
public class Errors {
    private List<Message> messages;
}
