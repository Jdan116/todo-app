package io.swagger.api;

import io.swagger.model.TodoRequest;
import io.swagger.model.TodoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-05-23T17:33:10.455Z")

@Controller
public class TodosApiController implements TodosApi {

    private static final Logger log = LoggerFactory.getLogger(TodosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TodosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<TodoResponse> createTodo(@ApiParam(value = "Todo object that needs to be added to the todo list" ,required=true )  @Valid @RequestBody TodoRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TodoResponse>(objectMapper.readValue("{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0,  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\"  }, {    \"name\" : \"name\",    \"description\" : \"description\"  } ]}", TodoResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TodoResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TodoResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTodo(@ApiParam(value = "ID of todo",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TodoResponse> getTodo(@ApiParam(value = "ID of todo",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TodoResponse>(objectMapper.readValue("{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0,  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\"  }, {    \"name\" : \"name\",    \"description\" : \"description\"  } ]}", TodoResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TodoResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TodoResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<TodoResponse>> getTodos() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<TodoResponse>>(objectMapper.readValue("[ {  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0,  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\"  }, {    \"name\" : \"name\",    \"description\" : \"description\"  } ]}, {  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0,  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\"  }, {    \"name\" : \"name\",    \"description\" : \"description\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<TodoResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<TodoResponse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTodo(@ApiParam(value = "ID of todo",required=true) @PathVariable("id") Long id,@ApiParam(value = "Todo object that needs to be added to the todo list" ,required=true )  @Valid @RequestBody TodoRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
