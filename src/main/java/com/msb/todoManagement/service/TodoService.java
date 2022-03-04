package com.msb.todoManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msb.todoManagement.model.Todo;
import com.msb.todoManagement.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAllTodos(){
		return todoRepository.findAll();
	}

	@Override
	public Optional<Todo> getTodoById(int id) {
		return todoRepository.findById(id);
	}

	@Override
	public void addTodo(String description, String targetDate) {
		saveTodo(new Todo(description, targetDate));
	}

	@Override
	public void editTodo(Todo todo) {
		saveTodo(todo);
	}

	@Override
	public void deleteTodo(int id) {
		Optional<Todo> todo = getTodoById(id);
		if(todo.isPresent())
			todoRepository.deleteById(id);
	}

	@Override
	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
}
