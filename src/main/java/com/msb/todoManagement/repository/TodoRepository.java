package com.msb.todoManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msb.todoManagement.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
