package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.model.EmployeeTask;

@Repository
public interface TaskRepo extends JpaRepository<EmployeeTask, Integer> {

}
