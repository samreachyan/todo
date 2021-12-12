package me.todo.todo.controller;


import me.todo.todo.entity.Todo;
import me.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoApiController {

//    private List<Todo> todoList = new CopyOnWriteArrayList<>();
    @Autowired
    private TodoService todoService;


    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        return todoService.getAllTodo();
    }


    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Long todoId) {
        return todoService.getByIdTodo(todoId);
    }


    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name = "todoId") Long todoId,
                         @RequestBody Todo todo) {
            Todo td = todoService.getByIdTodo(todoId);
            td.setTitle(todo.getTitle());
            td.setDetail(todo.getDetail());
            todoService.addNewTodo(td);
        return todoService.getByIdTodo(todoId);
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Long todoId) {
        todoService.remove(todoId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoService.addNewTodo(todo);
        return ResponseEntity.ok().body(todo);
    }
}
