package com.leanix.app.todos.global.exception.handler.exceptions;

import com.leanix.app.todos.global.exception.handler.model.Message;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;


@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicatedException extends RuntimeException {

	private final List<Message> errors = new ArrayList<>();

	public DuplicatedException() {
		super();
	}
	
	public DuplicatedException(List<Message> errors) {
		super();
		this.errors.addAll(errors);
	}

	public DuplicatedException(Message error) {
		super();
		this.errors.add(error);
	}
}

