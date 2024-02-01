package com.dmantz.taskManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.taskManagementSystem.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByUsersId(long userId);

}
