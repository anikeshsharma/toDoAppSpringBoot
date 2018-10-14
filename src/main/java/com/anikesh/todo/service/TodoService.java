package com.anikesh.todo.service;

import java.util.List;

import com.anikesh.todo.controller.model.TodoItem;

public interface TodoService {

	List<TodoItem> getTodoItems();

	TodoItem addTodoItem(TodoItem todoItem);

	void deleteTodoItem(Integer id);

	List<TodoItem> getTodoItems(boolean complete);

	void changeTodoItemStatus(Integer id, String status);

}
