package com.Zakaria.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TodoHardcodedService {


    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idCounter = 0;

    static {

        todos.add( new Todo(++idCounter, " in 28 minutes", " learn to dance", new Date(), false ));
        todos.add( new Todo(++idCounter, " in 28 minutes", " learn to Angular", new Date(), false ));
        todos.add( new Todo(++idCounter, " in 28 minutes", " learn to SpringBoot", new Date(), false ));
        todos.add( new Todo(++idCounter, " Zakaria", " learn to Football", new Date(), false ));

    }

    public List<Todo> findAll() {

        return todos;
    }

    public Todo save(Todo todo){
        //to be able to insert it
        if (todo.getId()==-1 || todo.getId()==0) {
            todo.setId(++idCounter);
            todos.add(todo);

        //to be able to update it
        } else {
            // i delete the todo and then add the new todo
            deleteById(todo.getId());
            todos.add(todo);

        }
        return todo;
    }


    public Todo deleteById( long id) {

            // on stock dans la variable local todo, le todo trouvé par id
        Todo todo =  findById(id);

        //on check si le todo est rempli ou pas
        if (todo==null)
            return null;
        //si on la bien remove, on renvoi le todo
       if (todos.remove(todo)) {
           return todo;

       }

            return null;
    }

    public Todo findById(long id) {
        for(Todo todo:todos){

            if (todo.getId() == id ) {
                 return todo;

            }
        }
        return null;
        }



}
