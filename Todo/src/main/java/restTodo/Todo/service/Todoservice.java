package restTodo.Todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restTodo.Todo.dao.Todorepository;
import restTodo.Todo.entity.Todo;

import java.util.List;
@Component
public class Todoservice {
    @Autowired
    Todo todo;
    @Autowired
    Todorepository todorepository;
    public Todo getTodobyid(int id){
        try{
            todo= this.todorepository.findById(id);
        }
            catch (Exception e){
            e.printStackTrace();
            }
        return todo;
    }
    public List<Todo> getalltodo(){
        List<Todo> todo=(List<Todo>)this.todorepository.findAll();
        return todo;
    }
    public void addtodo(Todo todo){
        Todo add=this.todorepository.save(todo);



    }
    public void update(Todo todo,int id){
        todo.setId(id);
        todorepository.save(todo);
    }
    public void deletetodo(int id){
        todorepository.deleteById(id);
    }



}
