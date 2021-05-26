package com.leanix.app.todos.database.dao;

import com.leanix.app.todos.database.dto.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
