/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.TodoRequest;
import io.swagger.model.TodoResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-05-23T17:33:10.455Z")

@Validated
@Api(value = "todos", description = "the todos API")
@RequestMapping(value = "/v1")
public interface TodosApi {

    @ApiOperation(value = "Create new todo", nickname = "createTodo", notes = "", response = TodoResponse.class, tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "CREATED", response = TodoResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "internal exception") })
    @RequestMapping(value = "/todos",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<TodoResponse> createTodo(@ApiParam(value = "Todo object that needs to be added to the todo list" ,required=true )  @Valid @RequestBody TodoRequest body);


    @ApiOperation(value = "Remove a specific todo", nickname = "deleteTodo", notes = "delete a spcific todo from a todos list", tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "internal exception") })
    @RequestMapping(value = "/todos/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTodo(@ApiParam(value = "ID of todo",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Retrieve a specific todo", nickname = "getTodo", notes = "get a specific todo with id", response = TodoResponse.class, tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = TodoResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "internal exception") })
    @RequestMapping(value = "/todos/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<TodoResponse> getTodo(@ApiParam(value = "ID of todo",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Retrieve all todo list(s)", nickname = "getTodos", notes = "", response = TodoResponse.class, responseContainer = "List", tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = TodoResponse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "internal exception") })
    @RequestMapping(value = "/todos",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TodoResponse>> getTodos();


    @ApiOperation(value = "modify a specific todo", nickname = "updateTodo", notes = "update the object of a specific todo", tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "internal exception") })
    @RequestMapping(value = "/todos/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTodo(@ApiParam(value = "ID of todo",required=true) @PathVariable("id") Long id,@ApiParam(value = "Todo object that needs to be added to the todo list" ,required=true )  @Valid @RequestBody TodoRequest body);

}
