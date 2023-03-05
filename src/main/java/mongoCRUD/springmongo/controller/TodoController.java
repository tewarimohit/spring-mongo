package mongoCRUD.springmongo.controller;


import mongoCRUD.springmongo.model.Todos;
import mongoCRUD.springmongo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todos createTodo(@RequestBody Todos todo){
        return service.addTodo(todo);
    }

    @GetMapping
    public List<Todos> getTodos(){
        return service.findAllTodos();
    }


    @GetMapping("/{todoId}")
    public Todos getTodo(@PathVariable String todoId){
        return service.getByTodoId(todoId);
    }

    @GetMapping("/title/{title}")
    public List<Todos> getTaskByTitle(@PathVariable String title){
        return  service.getByTitle(title);
    }
    @GetMapping("/status/{status}")
    public List<Todos> getTaskByStatus(@PathVariable Boolean status){
        return service.getByStatus(status);
    }

    @PutMapping
    public Todos modifyTodo(@RequestBody Todos todo){
        return service.updateTodo(todo);
    }

    @DeleteMapping("/{todoId}")
    public String deleteTodo(@PathVariable String todoId){
        return service.deleteTodo(todoId);
    }
}
