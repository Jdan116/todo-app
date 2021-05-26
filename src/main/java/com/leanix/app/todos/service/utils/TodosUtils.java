package com.leanix.app.todos.service.utils;

import com.leanix.app.todos.database.dto.Task;
import com.leanix.app.todos.database.dto.Todo;
import io.swagger.model.TodoRequest;
import io.swagger.model.TodoResponse;
import io.swagger.model.TodoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodosUtils {

    @Autowired
    Utils utils;

    public Todo buildTodoRequest(TodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setName(todoRequest.getName());
        todo.setDescription(todoRequest.getDescription());
        List<Task> tasks = new ArrayList<>();
        List<TodoTask> requestTasks = todoRequest.getTasks();
        for (TodoTask todoTask : utils.isSafeList(requestTasks)) {
            Task task = new Task();
            task.setName(todoTask.getName());
            task.setDescription(todoTask.getDescription());
            task.setTodo(todo);
            tasks.add(task);
        }
        todo.setTasks(tasks);
        return todo;
    }

    public TodoResponse bindCreateTodoResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        todoResponse.setId(todo.getTodoId());
        todoResponse.setName(todo.getName());
        todoResponse.setDescription(todo.getDescription());
        List<TodoTask> todoTasks = new ArrayList<>();
        List<Task> tasks = todo.getTasks();
        for (Task task : utils.isSafeList(tasks)) {
            TodoTask todoTask = new TodoTask();
            todoTask.setName(task.getName());
            todoTask.setDescription(task.getDescription());
            todoTasks.add(todoTask);
        }
        todoResponse.setTasks(todoTasks);
        return todoResponse;
    }

    public List<TodoResponse> bindGetTodosResponse(Iterable<Todo> todos) {
        List<TodoResponse> todoResponses = new ArrayList<>();
        for (Todo todo : utils.isSafeList(todos)) {
            TodoResponse todoResponse = new TodoResponse();
            todoResponse.setId(todo.getTodoId());
            todoResponse.setName(todo.getName());
            todoResponse.setDescription(todo.getDescription());
            List<TodoTask> tasks = new ArrayList<>();
            List<Task> taskList = todo.getTasks();
            for (Task task : utils.isSafeList(taskList)) {
                TodoTask todoTask = new TodoTask();
                todoTask.setName(task.getName());
                todoTask.setDescription(task.getDescription());
                tasks.add(todoTask);
            }
            todoResponse.setTasks(tasks);
            todoResponses.add(todoResponse);
        }
        return todoResponses;
    }

    public TodoResponse bindTodoGetTodoResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        todoResponse.setId(todo.getTodoId());
        todoResponse.setName(todo.getName());
        todoResponse.setDescription(todo.getDescription());
        List<TodoTask> tasks = new ArrayList<>();
        List<Task> todoTasks = todo.getTasks();
        for (Task task : utils.isSafeList(todoTasks)) {
            TodoTask todoTask = new TodoTask();
            todoTask.setName(task.getName());
            todoTask.setDescription(task.getDescription());
            tasks.add(todoTask);
        }
        todoResponse.setTasks(tasks);
        return todoResponse;
    }
}
