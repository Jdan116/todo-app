package com.leanix.app.todos.api;

import com.leanix.app.todos.service.TodosService;
import io.swagger.api.TodosApi;
import io.swagger.model.TodoRequest;
import io.swagger.model.TodoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodosApiDelegateImpl implements TodosApi {

    @Autowired
    TodosService todosService;

    @Override
    public ResponseEntity<TodoResponse> createTodo(TodoRequest body) {
        return new ResponseEntity<>(todosService.createTodo(body), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteTodo(Long id) {
        todosService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TodoResponse> getTodo(Long id) {
        return new ResponseEntity<>(todosService.getTodo(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TodoResponse>> getTodos() {
        return new ResponseEntity<>(todosService.getTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateTodo(Long id, TodoRequest body) {
        todosService.updateTodo(id, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
