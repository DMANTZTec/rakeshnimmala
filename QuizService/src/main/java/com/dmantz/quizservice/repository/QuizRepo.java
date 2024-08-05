package com.dmantz.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmantz.quizservice.common.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
