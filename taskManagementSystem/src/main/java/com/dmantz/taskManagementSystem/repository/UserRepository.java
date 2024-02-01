package com.dmantz.taskManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.taskManagementSystem.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
