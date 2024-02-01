package com.dmantz.taskManagementSystem.serviceImpl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.taskManagementSystem.entity.Task;
import com.dmantz.taskManagementSystem.entity.Users;
import com.dmantz.taskManagementSystem.exception.AccesDeclain;
import com.dmantz.taskManagementSystem.exception.TaskNotFound;
import com.dmantz.taskManagementSystem.exception.UserNotFound;
import com.dmantz.taskManagementSystem.payload.TaskDto;
import com.dmantz.taskManagementSystem.repository.TaskRepository;
import com.dmantz.taskManagementSystem.repository.UserRepository;
import com.dmantz.taskManagementSystem.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {
		
		Users users=userRepository.findById(userId).orElseThrow(
				()-> new UserNotFound(String.format("user id %d not found in database", userId))
				);
		Task task=modelMapper.map(taskDto, Task.class);
		task.setUsers(users);
		//after setting the user, we sorting data to db
		Task savedTask=taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(long userId) {
		
		userRepository.findById(userId).orElseThrow(
				()-> new TaskNotFound(String.format("Task id %d not found ", userId)));
		
		List<Task> task=taskRepository.findAllByUsersId(userId);
		return task.stream().map(
				task1->modelMapper.map(task1, TaskDto.class)
				).collect(Collectors.toList());
	}

	@Override
	public TaskDto getTask(long userId, long taskId) {
		Users users=userRepository.findById(userId).orElseThrow(
				()-> new UserNotFound(String.format("user id %d not found in database", userId))
				);
		
		Task task=taskRepository.findById(taskId).orElseThrow(
				()-> new  TaskNotFound(String.format("task id %d not found", taskId))
				
				);
		if(users.getId() != task.getUsers().getId()) {
			throw new AccesDeclain(String.format("Task id %d not belonging to user id %d", taskId,userId));
		}
		
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteTaskById(long userId,long taskId) {
		Users users=userRepository.findById(userId).orElseThrow(
				()-> new UserNotFound(String.format("user id %d not found in database", userId))
				);
		
		Task task=taskRepository.findById(taskId).orElseThrow(
				()-> new  TaskNotFound(String.format("task id %d not found", taskId))
				
				);
		if(users.getId() != task.getUsers().getId()) {
			throw new AccesDeclain(String.format("Task id %d not belonging to user id %d", taskId,userId));
			
		}
		taskRepository.deleteById(taskId);
		
		
		
	}

	

}
