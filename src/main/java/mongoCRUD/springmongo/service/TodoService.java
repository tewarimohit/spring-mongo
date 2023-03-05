package mongoCRUD.springmongo.service;

import mongoCRUD.springmongo.model.Todos;
import mongoCRUD.springmongo.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    private TodosRepository repository;

    //CRUD

    public Todos addTodo(Todos todo){
        todo.setTodoId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(todo);

    }

    public List<Todos> findAllTodos(){
        return repository.findAll();
    }

    public Todos getByTodoId(String todoId){
        return repository.findById(todoId).get();
    }

    // own method
    public List<Todos> getByTitle(String title){
        return  repository.findByTitle(title);
    }

    public List<Todos> getByStatus(Boolean status){
        return  repository.findByStatus(status);
    }

    public Todos updateTodo(Todos todoRequest){
        // get existing object
        Todos existingTodo= repository.findById(todoRequest.getTodoId()).get();
        existingTodo.setDescription(todoRequest.getDescription());
        existingTodo.setTitle(todoRequest.getTitle());
        existingTodo.setIsComplete(todoRequest.getIsComplete());

        return repository.save(existingTodo);
    }

    public String deleteTodo(String todoId){
        repository.deleteById(todoId);

        return todoId+"task deleted successfully";
    }
}
