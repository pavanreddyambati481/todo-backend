package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping
	public List<Todo> getAllTodos(){
		return todoRepository.findAll();
	}
	
	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return todoRepository.save(todo);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable int id) {
		todoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
		todo.setId(id);
		return todoRepository.save(todo);
		
	}
}
