package com.Zakaria.rest.webservices.restfulwebservices.todo;


import com.Zakaria.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TodoResource  {

    @Autowired
    private TodoHardcodedService todoService;


    //récuperer tous les todos
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();

    }

        //récupere un todo spécifique sur base de son id
    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);

    }


    //DELETE /users/{username}/todos/{id}
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {

        //we invoke te delete method from todoservice
        Todo todo = todoService.deleteById(id);

    //ResponseEntity nous permet de fr usage de different status, telque notfound ou nocontent
        if (todo != null)  {
                // when it is successful
                return ResponseEntity.noContent().build();
        }
        // when it is not successful
         return ResponseEntity.notFound().build();

    }

//EDIT
//PUT /users/{username}/todos/{todo_id}
    @PutMapping("/users/{username}/todos/{id}")
    //utiliser le Response Entity nous permet d'avoir + de poissibilités a l'avenir et avoir davantage de statut etc
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
                                           @RequestBody Todo todo) {
        Todo todoUpdated = todoService.save(todo);

        //return a todo with all the content of it and also a status of ok
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

//CREATE
// POST /users/{username}/todos
    @PostMapping ("/users/{username}/todos")
    //utiliser le Response Entity nous permet d'avoir + de poissibilités a l'avenir et avoir davantage de statut etc
    public ResponseEntity<Void> updateTodo(@PathVariable String username,
                                       @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);

        //Location
        //Get current resource url
        //we take the path and added the id
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
}
}
