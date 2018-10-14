package com.anikesh.todo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anikesh.todo.controller.model.TodoItem;
import com.anikesh.todo.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoRestController {

	@Autowired
	private TodoService todoService;

	private static final Logger LOG = LoggerFactory.getLogger(TodoRestController.class);

	/*@RequestMapping("/login")
	public String sayHello() {
		return "login";
	}*/
	
	
	@RequestMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }
	
	

	//@RequestMapping(value = "/index.html")
	@GetMapping("/getTodo")
	public List<TodoItem> getTodoItems(@RequestParam(required = false) Boolean complete) {
		if (null == complete) {
			LOG.debug("Request to Get To Do Items received");
			return todoService.getTodoItems();
		} else {
			LOG.debug("Request to Get Completed To Do Items received");
			return todoService.getTodoItems(complete);
		}
	}

	//@RequestMapping(value = "/addItem.html")
	@PostMapping("/addItem")
	public TodoItem addTodoItem(@RequestBody TodoItem todoItem) {
		LOG.debug("Request to Add To Do Items received");
		return todoService.addTodoItem(todoItem);

	}

	@DeleteMapping("/{id}")
	public void deleteTodoItem(@PathVariable Integer id) {
		LOG.debug("Request to Delete To Do Item of Id " + id + " received");
		todoService.deleteTodoItem(id);
	}

	@PostMapping("/todo/id/{id}/status/{status}")
	public void changeTodoItemStatus(@PathVariable Integer id, @PathVariable String status) {

		LOG.debug("Request to Change Status of To Do Item of Id " + id + " received");
		todoService.changeTodoItemStatus(id, status);

	}

}
