package com.dmantz.rediscache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmantz.rediscache.common.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
