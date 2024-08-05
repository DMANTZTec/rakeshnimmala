package com.dmantz.questionservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dmantz.questionservice.common.QuestionWrapper;
import com.dmantz.questionservice.common.Questions;
import com.dmantz.questionservice.common.Response;
import com.dmantz.questionservice.repository.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	public ResponseEntity<List<Questions>> getAllQuestions() {
		return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
	}

	public List<Questions> getQuestionsByLanguage(String language) {
		return questionRepo.getQuestionsByLanguage(language);
	}

	public void addQuestion(Questions questions) {
		questionRepo.save(questions);
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String language, int numQuestions) {
		List<Integer> questions = questionRepo.findRandomQuestionsByLanguage(language, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsForId(List<Integer> questionIds) {
		List<QuestionWrapper> questionWrappers = new ArrayList<>();
		for (Integer id : questionIds) {
			Optional<Questions> optionalQuestion = questionRepo.findById(id);
			if (optionalQuestion.isPresent()) {
				Questions question = optionalQuestion.get();
				QuestionWrapper questionWrapper = new QuestionWrapper();
				questionWrapper.setId(question.getId());
				questionWrapper.setQuestion(question.getQuestion());
				questionWrapper.setOption1(question.getOption1());
				questionWrapper.setOption2(question.getOption2());
				questionWrapper.setOption3(question.getOption3());
				questionWrapper.setOption4(question.getOption4());
				questionWrappers.add(questionWrapper);
			}
		}
		return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> response) {

		int right = 0;
		for (Response response2 : response) {
			Questions questions = questionRepo.findById(response2.getId()).get();
			if (response2.getResponse().equals(questions.getAnswer())) {
				right++;
			}
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
