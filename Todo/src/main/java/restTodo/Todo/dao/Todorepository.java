package restTodo.Todo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import restTodo.Todo.entity.Todo;
@Component

public interface Todorepository extends CrudRepository<Todo,Integer> {
    public Todo findById(int id);
}
