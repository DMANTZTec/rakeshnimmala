package com.dmantz.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmantz.auth.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String username);

}
