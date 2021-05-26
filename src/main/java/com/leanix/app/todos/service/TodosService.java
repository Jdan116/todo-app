package com.leanix.app.todos.service;

import com.leanix.app.todos.database.dao.TodoRepository;
import com.leanix.app.todos.database.dto.Task;
import com.leanix.app.todos.database.dto.Todo;
import com.leanix.app.todos.global.exception.handler.exceptions.NotFoundException;
import com.leanix.app.todos.global.exception.handler.model.Message;
import com.leanix.app.todos.service.utils.TodosUtils;
import com.leanix.app.todos.service.utils.Utils;
import io.swagger.model.TodoRequest;
import io.swagger.model.TodoResponse;
import io.swagger.model.TodoTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TodosService {

    @Autowired
    Utils utils;

    @Autowired
    TodosUtils todosUtils;

    @Autowired
    TodoRepository todoRepository;

    public List<TodoResponse> getTodos() {
        log.info("getTodos - getting todo list");
        Iterable<Todo> todos = todoRepository.findAll();
        return todosUtils.bindGetTodosResponse(todos);
    }

    public TodoResponse createTodo(TodoRequest todoRequest) {
        log.info("createTodo - creating todo. todoRequest: {}", utils.toJson(todoRequest));
        Todo todo = todosUtils.buildTodoRequest(todoRequest);
        Todo save = todoRepository.save(todo);
        return todosUtils.bindCreateTodoResponse(save);
    }

    public TodoResponse getTodo(Long id) {
        log.info("getTodo - getting todo id = {}", id);
        Optional<Todo> todo = todoRepository.findById(id);
        if (!todo.isPresent()) {
            todoNotFound(id);
        }
        return todosUtils.bindTodoGetTodoResponse(todo.get());
    }

    public void updateTodo(Long id, TodoRequest todoRequest) {
        log.info("updateTodo - getting todo id = {} todoRequest: {}", id, utils.toJson(todoRequest));

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setName(todoRequest.getName());
            todo.setDescription(todoRequest.getDescription());
            List<Task> tasks = new ArrayList<>();
            for (TodoTask todoTask : utils.isSafeList(todoRequest.getTasks())) {
                Task task = new Task();
                task.setName(todoTask.getName());
                task.setDescription(todoTask.getDescription());
                task.setTodo(todo);
                tasks.add(task);
            }
            todo.setTasks(tasks);
            todoRepository.save(todo);
            return;
        }
        todoNotFound(id);
    }

    private void todoNotFound(Long id) {
        Message error = new Message();
        error.setCode(400);
        error.setField("id");
        error.setDescription("Todo with Id=" + id + " is not found");
        throw new NotFoundException(error);
    }

    public void deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            todoRepository.deleteById(id);
            return;
        }
        todoNotFound(id);
    }
}
