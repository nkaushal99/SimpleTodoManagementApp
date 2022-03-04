package com.msb.todoManagement.service;

import java.util.List;
import java.util.Optional;

import com.msb.todoManagement.model.Todo;

public interface ITodoService {
	
	List<Todo> getAllTodos();
	
	Optional<Todo> getTodoById(int id);
	
	void addTodo(String desc, String TargetDate);
	
	void editTodo(Todo todo);
	
	void deleteTodo(int id);
	
	void saveTodo(Todo todo);
	
}
