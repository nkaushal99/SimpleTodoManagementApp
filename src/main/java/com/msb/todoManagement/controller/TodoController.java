package com.msb.todoManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.msb.todoManagement.model.Todo;
import com.msb.todoManagement.service.ITodoService;

@Controller
public class TodoController {
	
	@Autowired
	private ITodoService todoService;
	
	@GetMapping("/list-todos")
	public String showTodos(Model model){
		model.addAttribute("todos", todoService.getAllTodos());
//		System.out.println(todoService.getAllTodos());
		return "list-todos";
	}
	
	@GetMapping("/add-todo")
	public String showAddTodoPage(){
		return "add-todo";
	}
	
	@PostMapping("/add-todo")
	public String addTodo(HttpServletRequest req, Model model){
		todoService.addTodo(req.getParameter("description"), req.getParameter("date"));
//		System.out.println(req.getParameter("date").getClass());
		return "redirect:/list-todos";
	}
	
	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@GetMapping("/edit-todo")
	public ModelAndView showEditTodoPage(@RequestParam int id){
		Todo todo = todoService.getTodoById(id).get();
		ModelAndView mv = new ModelAndView("edit-todo");
	    mv.addObject("todo", todo);//.addAttribute("todo", todo).addAttribute("id", id);
		return mv;
	}
	
	@PostMapping("/edit-todo")
	public String editTodo(HttpServletRequest req, ModelAndView mv){
		Todo todo = todoService.getTodoById(Integer.parseInt(req.getParameter("id"))).get();
		todo.setdescription(req.getParameter("description"));
		todo.setTargetDate(req.getParameter("targetDate"));
		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}
}