package com.dmantz.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.questionservice.common.QuestionWrapper;
import com.dmantz.questionservice.common.Questions;
import com.dmantz.questionservice.common.Response;
import com.dmantz.questionservice.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@GetMapping("/all")
	public ResponseEntity<List<Questions>> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("/language/{language}")
	public List<Questions> getQuestionsByLanguage(@PathVariable String language) {
		return questionService.getQuestionsByLanguage(language);

	}

	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody Questions questions) {
		questionService.addQuestion(questions);
		return "Question Added Successfully";
	}

	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String language,
			@RequestParam int numQuestions) {
		return questionService.getQuestionsForQuiz(language, numQuestions);
	}

	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsForId(@RequestBody List<Integer> questionIds) {
		return questionService.getQuestionsForId(questionIds);
	}

	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response) {
		return questionService.getScore(response);

	}

}
