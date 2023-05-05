package restTodo.Todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restTodo.Todo.entity.Todo;
import org.springframework.http.ResponseEntity;
import restTodo.Todo.service.Todoservice;

import java.util.List;
import java.util.Optional;

@RestController

public class Todocontroller {
    @Autowired
    Todoservice todoservice;
    @CrossOrigin(origins = "http://localhost:5174")
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getalltodos(){
        List<Todo> todo=this.todoservice.getalltodo();
        if(todo.size()<=0){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(todo));
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> gettodobyid(@PathVariable("id") int id){
      Todo todo= this.todoservice.getTodobyid(id);
      if(todo==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.of(Optional.of(todo));
    }
    @DeleteMapping("/todos/{id}")
    public void deletetodo(@PathVariable("id") int id){
        this.todoservice.deletetodo(id);
    }
    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping("/todos")
    public ResponseEntity<Todo> addtodo(@RequestBody Todo todo){
        this.todoservice.addtodo(todo);
        return ResponseEntity.of(Optional.of(todo));
    }
    @PutMapping("/todos/{id}")
    public void updatetodo(Todo todo ,@PathVariable("id") int id){
        this.updatetodo(todo,id);
    }

}
