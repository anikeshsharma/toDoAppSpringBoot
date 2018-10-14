package com.anikesh.todo.service.impl;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anikesh.todo.controller.model.TodoItem;
import com.anikesh.todo.dao.TodoRepository;
import com.anikesh.todo.entity.TodoItemEntity;
import com.anikesh.todo.service.TodoService;

@Component
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	private static final Logger LOG = LoggerFactory.getLogger(TodoServiceImpl.class);

	@Override
	public List<TodoItem> getTodoItems() {
		List<TodoItemEntity> list = todoRepository.findAll();
		LOG.debug("To Do Items Retreived " + list);
		Type type = new TypeToken<List<TodoItem>>() {
		}.getType();
		return modelMapper.map(list, type);

	}

	@Override
	public TodoItem addTodoItem(TodoItem todoItem) {
		LOG.debug("To Do Item- " + todoItem.getName() + " added");
		todoItem.setDate(LocalDateTime.now().toString());
		todoItem.setDescription("Item Added");
		return modelMapper.map(todoRepository.save(modelMapper.map(todoItem, TodoItemEntity.class)), TodoItem.class);
	}

	@Override
	public void deleteTodoItem(Integer id) {
		LOG.debug("To Do Item with " + id + " deleted");
		todoRepository.delete(id);
	}

	@Override
	public List<TodoItem> getTodoItems(boolean complete) {
		LOG.debug("Fetching ToDoItem List");
		List<TodoItemEntity> list = todoRepository.findByComplete(complete);
		if (complete) {
			LOG.debug("ToDoItem List which is completed " + list);
		}
		Type type = new TypeToken<List<TodoItem>>() {
		}.getType();
		return modelMapper.map(list, type);
	}

	@Override
	public void changeTodoItemStatus(Integer id, String status) {
		TodoItemEntity todoItemEntity = todoRepository.findById(id);
		if (null != todoItemEntity) {
			if (status != null && status.equals("pending")) {
				todoItemEntity.setComplete(false);
				todoItemEntity.setDate(LocalDateTime.now().toString());
				todoItemEntity.setDescription("Item Marked To Pending From Completed");
			} else {
				todoItemEntity.setComplete(true);
				todoItemEntity.setDate(LocalDateTime.now().toString());
				todoItemEntity.setDescription("Item Marked To Completed");
			}

			todoRepository.save(todoItemEntity);
			LOG.debug("ToDoItem with Id " + id + "Status Changed to" + status);

		}
	}

}
