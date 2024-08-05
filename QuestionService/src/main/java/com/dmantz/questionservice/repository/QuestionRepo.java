package com.dmantz.questionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dmantz.questionservice.common.Questions;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer> {

	public List<Questions> getQuestionsByLanguage(String language);

	@Query(value = "SELECT q.id FROM questions q WHERE q.language =:language ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	public List<Integer> findRandomQuestionsByLanguage(String language, int numQ);

}
