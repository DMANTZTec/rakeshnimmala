package com.dmantz.taskManagementSystem.service;

import java.util.List;

import com.dmantz.taskManagementSystem.payload.TaskDto;

public interface TaskService {
	
	public TaskDto saveTask(long userId,TaskDto taskDto);
	
	public List<TaskDto> getAllTasks(long userId);
	
	public TaskDto getTask(long userId,long taskId);
	

	void deleteTaskById(long userId, long taskId);

}
