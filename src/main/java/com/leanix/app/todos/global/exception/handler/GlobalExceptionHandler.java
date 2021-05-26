package com.leanix.app.todos.global.exception.handler;

import com.leanix.app.todos.global.exception.handler.exceptions.*;
import com.leanix.app.todos.global.exception.handler.model.Errors;
import com.leanix.app.todos.global.exception.handler.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private Message buildErrorMessage(int code, String field, String errorMessage) {
        Message message = new Message();
        message.setCode(code);
        message.setField(field);
        message.setDescription(errorMessage);
        return message;
    }

    private Errors buildAndPrintErrors(List<Message> errorMessageList, String loggedExceptionName) {
        Errors errors = new Errors();
        errors.setMessages(errorMessageList);
        for(Message e:errors.getMessages()) {
            log.error("GlobalExceptionHandler - {}: {}", loggedExceptionName, e != null ? e.getDescription() : null);
        }
        return errors;
    }


    @ExceptionHandler(DataException.class)
    public ResponseEntity<Errors> globalExceptionHandler(DataException ex, WebRequest request) {
        Errors errors = this.buildAndPrintErrors(ex.getErrors(), DataException.class.getName());
        return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Errors> globalExceptionHandler(UnauthorizedException ex, WebRequest request) {

        Errors errors = this.buildAndPrintErrors(ex.getErrors(), UnauthorizedException.class.getName());
        return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Errors> globalExceptionHandler(ForbiddenException ex, WebRequest request) {

        Errors errors = this.buildAndPrintErrors(ex.getErrors(), ForbiddenException.class.getName());
        return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Errors> globalExceptionHandler(NotFoundException ex, WebRequest request) {

        Errors errors = this.buildAndPrintErrors(ex.getErrors(), NotFoundException.class.getName());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ServiceUnavailableException.class})
    public ResponseEntity<Errors> globalExceptionHandler(ServiceUnavailableException ex, WebRequest request) {

        ex.printStackTrace();
        Errors errors = this.buildAndPrintErrors(ex.getErrors(), ServiceUnavailableException.class.getName());
        return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
