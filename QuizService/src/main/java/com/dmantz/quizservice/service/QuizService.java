package com.dmantz.quizservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dmantz.quizservice.common.QuestionWrapper;
import com.dmantz.quizservice.common.Quiz;
import com.dmantz.quizservice.common.Response;
import com.dmantz.quizservice.controller.QuizIntereface;
import com.dmantz.quizservice.repository.QuizRepo;

@Service
public class QuizService {
	@Autowired
	QuizRepo quizRepo;

	@Autowired
	QuizIntereface quizIntereface;

	public ResponseEntity<String> createQuiz(String language, int numQ, String title) {

		List<Integer> questions = quizIntereface.getQuestionsForQuiz(language, numQ).getBody();

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Integer> questionids = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizIntereface.getQuestionsForId(questionids);

		return questions;
	}

	public ResponseEntity<Integer> calulateResult(int id, List<Response> response) {

		ResponseEntity<Integer> score = quizIntereface.getScore(response);
		return score;
	}

}
