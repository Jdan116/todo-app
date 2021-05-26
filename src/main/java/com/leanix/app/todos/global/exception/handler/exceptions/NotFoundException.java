package com.leanix.app.todos.global.exception.handler.exceptions;

import com.leanix.app.todos.global.exception.handler.model.Message;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private final List<Message> errors = new ArrayList<>();

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(List<Message> errors) {
		super();
		this.errors.addAll(errors);
	}

	public NotFoundException(Message error) {
		super();
		this.errors.add(error);
	}
}

