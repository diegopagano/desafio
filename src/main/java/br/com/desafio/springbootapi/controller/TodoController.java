package br.com.desafio.springbootapi.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import br.com.desafio.springbootapi.entity.Todo;
import br.com.desafio.springbootapi.repository.TodoRepository;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository _todoRepository;

    @ApiOperation(value = "Retorna uma lista de Tarefas")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a lista de tarefas"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/todos", method = RequestMethod.GET, produces="application/json") //PATH > OQ VAI FAZER > OQ ELE "PRODUZ"
    public List<Todo> Get() { //retorna uma lista de todas todos
   
        return _todoRepository.findAll();
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET, produces="application/json") //METODO PARA DAR UM GET PELO ID EM ESPECIFICO
    public ResponseEntity<Todo> GetById(@PathVariable(value = "id") long id) //busca pelo id
    {
        Optional<Todo> todo = _todoRepository.findById(id);
        if(todo.isPresent())
            return new ResponseEntity<Todo>(todo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	
    }

    @RequestMapping(value = "/todos", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Todo> Post(@Valid @RequestBody Todo todo) //POST COLOCA ALGUEM NO BANCO A PARTIR DO CORPO DA REQUISIÇÃO
    {
    	return new ResponseEntity<Todo>(_todoRepository.save(todo), HttpStatus.CREATED);
        
    }

    @RequestMapping(value = "/todos/{id}", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Todo> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Todo newTodo) //UPDATE NA PESSOA DENTRO DO BANCO
    {
        Optional<Todo> oldTodo = _todoRepository.findById(id);
        if(oldTodo.isPresent()){ //SE ELE ESTIVER NO BANCO
            Todo todo = oldTodo.get();
            todo.setDescription(newTodo.getDescription());
            todo.setCompleted(newTodo.isCompleted());
            _todoRepository.save(todo);
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //SE ELE NAO ENCONTRA NA TABELA
    	
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) //DELETA DO BANCO
    {
        Optional<Todo> todo = _todoRepository.findById(id);
        if(todo.isPresent()){
            _todoRepository.delete(todo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	
    }
}