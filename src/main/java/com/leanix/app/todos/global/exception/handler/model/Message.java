package com.leanix.app.todos.global.exception.handler.model;

import lombok.Data;

@Data
public class Message {
    private int code;
    private String field;
    private String description;
}
